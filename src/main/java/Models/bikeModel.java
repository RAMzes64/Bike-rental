package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class bikeModel {

    private String type;

    private String name;

    private int payPerDay;

    private static Connection connection ;

    private static PreparedStatement statement;

    private static ResultSet resultSet;

    public bikeModel(String type, String name, int payPerDay){
        this.type = type;
        this.name = name;
        this.payPerDay = payPerDay;
    }

    public String getName() {
        return name;
    }

    public ArrayList<bikeModel> getAllModels(DataBaseSingleton db) throws SQLException {

        connection = null;
        statement = null;
        resultSet = null;
        ArrayList<bikeModel> bikeModels = new ArrayList<>();

        try{
            connection = db.getConnection();
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

    public bikeModel(int id, DataBaseSingleton db) throws SQLException{
        connection = null;
        statement = null;
        resultSet = null;

        try{
            connection = db.getConnection();
            statement = connection.prepareStatement("SELECT type, name, payment FROM models WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            type = resultSet.getString(1);
            name = resultSet.getString(2);
            payPerDay = resultSet.getInt(3);
        }
        catch (Exception e){

        }
        finally {
            if(resultSet != null) resultSet.close();
            if(connection != null) connection.close();
            if(statement != null) statement.close();
        }
    }
}
