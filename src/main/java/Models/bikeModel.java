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

    private Connection connection ;

    private PreparedStatement statement;

    private ResultSet resultSet;

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
        String request = "SELECT type, name, pay_per_day FROM models WHERE id = ?;";
        try{
            connection = DataBaseSingleton.getConnection();
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                type = resultSet.getString(1);
                name = resultSet.getString(2);
                payPerDay = resultSet.getInt(3);
            }
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

    public int getPayPerDay(){
        return payPerDay;
    }

}
