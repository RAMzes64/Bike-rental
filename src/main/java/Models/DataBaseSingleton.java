package Models;

import java.sql.*;
public class DataBaseSingleton {
    private static DataBaseSingleton dataBase;

    private Connection connection = null;

    private PreparedStatement statement = null;

    private DataBaseSingleton(){}

    public static DataBaseSingleton getInstance(){
        if(dataBase == null)
            dataBase = new DataBaseSingleton();
        return dataBase;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("", "", "");
    }
    public void registration(String number, String series, String address, String passsword){
        try {
            connection = this.getConnection();
            statement = connection.prepareStatement("");
            statement.setString(2, number);
            statement.setString(3, series);
            statement.setString(4, address);
            statement.setString(5, passsword);
        }

        catch (Exception e){

        }
    }
}
