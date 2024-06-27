package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    protected int _id;

    protected String _name;

    protected String _password;

    protected String _Passport;


    protected static PreparedStatement statement;

    protected static ResultSet resultSet;

    public int getId(){
        return _id;
    }

    public static User logIn(String name, String password) throws SQLException {//Надо переписать
        statement = null;
        resultSet = null;

        try {
            statement = DataBaseSingleton.getConnection().prepareStatement("SELECT id, name, aes_decrypt(password, 'key'), access FROM users WHERE name = ? AND password = ?");
            statement.setString(1, name);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getInt(4) == 2){

                } else if (resultSet.getInt(4) == 3) {

                }
                else return new Client(resultSet.getInt(1));
            }
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
        }
        catch (Exception e){

        }
        return new User();
    }
}
