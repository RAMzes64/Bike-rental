package Models;

import java.sql.Connection;
import java.sql.SQLException;

public class Client extends User{

    private String _address;

    private String _city;

    public Client(int id){
        _id = id;
    }

    public void setAddress(DataBaseSingleton db,String address, String city){
        _address = address;
        _city = city;
    }
    public void registration(String name, String passport, String passsword, Connection connection) throws SQLException {

        statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO users(aes_encrypt(passport, 'key'), name, aes_encrypt(password, 'key'), access) VALUES (?, ?, aes_encrypt(?,'key'), ?");
            statement.setString(1, name);
            statement.setString(2, passport);
            statement.setString(3, passsword);
            statement.setInt(4, 1);
        }

        catch (Exception e){

        }
        finally {
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
        }
    }
}
