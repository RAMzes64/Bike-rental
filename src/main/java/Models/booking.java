package Models;

import java.sql.PreparedStatement;

public class booking {

    public booking(String date, int idC, int idShopModel){
    try{
        PreparedStatement statement = DataBaseSingleton.getConnection().prepareStatement("INSERT INTO booking(....) VALUES (...)");
        //statement.setString(1, getPaycheck);
        statement.setInt(4, 1);
        System.out.println("Что-то не так1");

        if(statement != null) statement.close();
    }
    catch (Exception e){

    }
    }

    private int getPaycheck(){
        return 100;
    }


}
