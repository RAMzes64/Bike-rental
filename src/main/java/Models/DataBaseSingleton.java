package Models;

import java.sql.*;
import java.util.ArrayList;

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

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://address=(protocol=tcp)(host=127.0.0.1)(port=3306)/bikeservice", "root", "" );

//        return DriverManager.getConnection("", "", "");
    }

    public ArrayList<bikeModel> getAllModels() throws  SQLException{

        connection = null;
        statement = null;
        resultSet = null;
        ArrayList<bikeModel> bikeModels = new ArrayList<>();

        try{
            connection = this.getConnection();
            statement = connection.prepareStatement("SELECT type, name, payment FROM models");
            resultSet = statement.executeQuery();

            for(int i = 0; resultSet.next(); i++){
                bikeModels.add(new bikeModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        }
        catch (Exception e){

        }
        finally {
            if(resultSet != null) resultSet.close();
            if(connection != null) connection.close();
            if(statement != null) statement.close();
        }

        return bikeModels;
    }

    public void typo() throws SQLException, ClassNotFoundException {
        connection = null;
        statement = null;
        resultSet = null;
        System.out.println("1+++++++");

            connection = this.getConnection();
            statement = connection.prepareStatement("SELECT type, name, payment FROM models");
            resultSet = statement.executeQuery();
            if(resultSet.next()) System.out.println("1213");
            else System.out.println("6767");
    }
}
