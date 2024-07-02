package Models;

import java.sql.*;
import java.util.ArrayList;
public class DataBaseSingleton {
    private static Connection connection = null;

    private DataBaseSingleton(){}

    public static Connection getConnection()throws Exception{
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://address=(protocol=tcp)(host=127.0.0.1)(port=3306)/bikeservice", "root", "");
            }
        }
        catch (Exception e){

        }
        return connection;
    }
}
