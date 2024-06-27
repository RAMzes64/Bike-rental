package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client extends User{

    private String _address;

    private String _city;

    public Client(int id){
        _id = id;
    }

    public static void registration(String name, String passport, String passsword) throws Exception {
        PreparedStatement statement = null;
        String request = "INSERT INTO users(passport, name, password, access) VALUES (aes_encrypt(?,'key'), ?, aes_encrypt(?,'key'), 1)";
        statement = DataBaseSingleton.getConnection().prepareStatement(request);
        statement.setString(1, passport);
        statement.setString(2, name);
        statement.setString(3, passsword);
        System.out.println(statement.executeUpdate());

        if(statement != null) statement.close();
    }
    public void changeData(String[] strings){
        statement = null;
        String request = "UPDATE users SET name = ?, passport = ?, password = ?, address = ? WHERE id = ?";
        try{
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setString(1, strings[0]);
            statement.setString(2, strings[1] + strings[2]);
            statement.setString(3, strings[4]);
            statement.setString(4, strings[3]);
            statement.setString(4, String.valueOf(_id));
            System.out.println(statement.executeUpdate());
            if(statement != null) statement.close();
        }
        catch (Exception e){

        }

    }
}
