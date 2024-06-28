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

    private int id;

    private static Connection connection ;

    private static PreparedStatement statement;

    private static ResultSet resultSet;

    public bikeModel(int id, String type, String name, int payPerDay){
        this.type = type;
        this.name = name;
        this.payPerDay = payPerDay;
        this.id = id;
    }
    public bikeModel(int id) throws SQLException{
        connection = null;
        statement = null;
        resultSet = null;

        try{
            statement = DataBaseSingleton.getConnection().prepareStatement("SELECT type, name, payment FROM models WHERE id = ?");
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


    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public ArrayList<bikeModel> getAllModels(DataBaseSingleton db) throws SQLException {

        connection = null;
        statement = null;
        resultSet = null;
        ArrayList<bikeModel> bikeModels = new ArrayList<>();

        try{
            connection = db.getConnection();
            statement = connection.prepareStatement("SELECT id, type, name, payment FROM models");
            resultSet = statement.executeQuery();

            for(int i = 0; resultSet.next(); i++){
                bikeModels.add(new bikeModel(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
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
}
