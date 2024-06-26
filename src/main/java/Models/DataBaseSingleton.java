package Models;

import java.sql.*;
public class DataBaseSingleton {
    private static DataBaseSingleton dataBase;

    private Connection connection ;

    private PreparedStatement statement;

    private ResultSet resultSet;

    private DataBaseSingleton(){}

    public static DataBaseSingleton getInstance(){
        if(dataBase == null)
            dataBase = new DataBaseSingleton();
        return dataBase;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("", "", "");

//        return DriverManager.getConnection("", "", "");
    }
    public void registration(String name, String passport, String passsword){
        connection = null;
        statement = null;
        try {
            connection = this.getConnection();
            statement = connection.prepareStatement("INSERT INTO users(passport, name, password, access) VALUES (?, ?, aes_encrypt(?,'key'), ?");
            statement.setString(1, name);
            statement.setString(2, passport);
            statement.setString(3, passsword);
            statement.setInt(4, 1);
        }

        catch (Exception e){

        }
    }

    public boolean logIn(String name, String password) throws SQLException {

        connection = null;
        statement = null;
        resultSet = null;

        try {
            connection = this.getConnection();
            statement = connection.prepareStatement("SELECT name, aes_decrypt(password, 'key') FROM user WHERE name = ? AND password = ?");
            statement.setString(1, name);
            statement.setString(2, password);
            if (!resultSet.getString(1).equals(null) && !resultSet.getString(2).equals(null)) return false;
            return false;
        }
        catch (Exception e){

        }

        finally {
            if(resultSet != null) resultSet.close();
            if(connection != null) connection.close();
            if(statement != null) statement.close();

        }

        return false;
    }
}
