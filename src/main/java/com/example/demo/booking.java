package com.example.demo;

import Models.DataBaseSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class booking {
    private int id;
    private int idUser;
    private int idShopModel;
    private String date;
    private int prepay;
    private int idBikeModel;

    public booking(String date, int idC, int idShopModel){
        String request = "INSERT INTO booking(id_user, id_shop_model, date, prepay) VALUES (?, ?, CONVERT( DATE, ?, 10), ?);";
    try{
        PreparedStatement statement = DataBaseSingleton.getConnection().prepareStatement(request);
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

    public booking(int id, int idUser, int idShopModel, String date, int prepay) throws Exception{
        this.id = id;
        this.idUser = idUser;
        this.idShopModel = idShopModel;
        this.date = date;
        this.prepay = prepay;
        idBikeModel = getBikeId();
    }

    public int getId() {
        return id;
    }

    public int getIdShopModel() {
        return idShopModel;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getDate() {
        return date;
    }

    public int getPrepay() {
        return prepay;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdShopModel(int idShopModel) {
        this.idShopModel = idShopModel;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setPrepay(int prepay) {
        this.prepay = prepay;
    }

    private int getBikeId() throws Exception{
        String request = "SELECT models.id FROM shop_models JOIN models ON shop_models.id_model = models.id WHERE shop_models.id = ?;";
        PreparedStatement statement = DataBaseSingleton.getConnection().prepareStatement(request);
        statement.setInt(1, idShopModel);
        ResultSet r = statement.executeQuery();
        while(r.next()){
            int id = r.getInt(1);
        }
        return id;
    }
}
