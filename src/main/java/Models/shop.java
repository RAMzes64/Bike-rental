package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class shop {

    private String name;

    private String address;

    private static Connection connection ;

    private static PreparedStatement statement;

    private static ResultSet resultSet;

    public shop(String name, String address){
        this.name = name;
        this.address = address;
    }

    public static ArrayList<shop> getAllShops(DataBaseSingleton db) throws SQLException {
        connection = null;
        statement = null;
        resultSet = null;
        ArrayList<shop> shops = new ArrayList<>();

        try{
            connection = db.getConnection();
            statement = connection.prepareStatement("SELECT address, name FROM models");
            resultSet = statement.executeQuery();

            for(int i = 0; resultSet.next(); i++){
                shops.add(new shop(resultSet.getString(2), resultSet.getString(1)));
            }
        }
        catch (Exception e){

        }
        finally {
            if(resultSet != null) resultSet.close();
            if(connection != null) connection.close();
            if(statement != null) statement.close();
        }

        return shops;
    }

    public String getName(){
        return name;
    }
}
