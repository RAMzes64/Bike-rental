package Models;

import java.sql.Connection;
import java.sql.SQLException;

public class Client extends User{

    private String _address;

    private String _city;

    public Client(int id){
        _id = id;
    }

    public static void registration(String name, String passport, String passsword) throws SQLException {
        statement = null;
        try {
            statement = DataBaseSingleton.getConnection().prepareStatement("INSERT INTO example(passport, name, password, access) VALUES (aes_encrypt(?,'key'), ?, aes_encrypt(?,'key'), 1");
            statement.setString(1, name);
            statement.setString(2, passport);
            statement.setString(3, passsword);
            statement.setInt(4, 1);
            System.out.println("Что-то не так1");

            if(statement != null) statement.close();
        }

        catch (Exception e){
            System.out.println("Что-то не так");
        }
    }
}
