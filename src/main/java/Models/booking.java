package Models;

import java.sql.PreparedStatement;

public class booking {

    public booking(String date, int idC, int idShopModel){
    try{
        PreparedStatement statement = DataBaseSingleton.getConnection().prepareStatement("INSERT INTO booking(id_user, id_shop_model, date, prepay) VALUES (?, ?, CONVERT( DATE, ?, 10), ?)");
        statement.setInt(1, idC);
        statement.setInt(2, idShopModel);
        statement.setString(3, date);
        statement.setInt(4,getPaycheck());
        System.out.println(statement.executeUpdate());
        if(statement != null) statement.close();
    }
    catch (Exception e){

    }
    }

    private int getPaycheck(){
        return 100;
    }


}
