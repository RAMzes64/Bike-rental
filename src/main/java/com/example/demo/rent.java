package com.example.demo;

import Models.DataBaseSingleton;
import Models.bikeModel;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class rent {
    private String id;
    private String clientId;
    private String bikeId;
    private String dateBegin;
    private String dateEnd;
    private String paycheck;

    private PreparedStatement statement;

    public rent(){

    }
    public rent(String clientId, String bikeId, String dateBegin){
        this.id = null;
        this.clientId = clientId;
        this.bikeId = bikeId;
        this.dateBegin = dateBegin;
        dateEnd = "";
        paycheck = "";
    }

    public rent(String id, String clientId, String bikeId, String dateBegin){
        this.id = id;
        this.clientId = clientId;
        this.bikeId = bikeId;
        this.dateBegin = dateBegin;
        dateEnd = "";
        paycheck = "";
    }

    public void setPaycheck() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        int result =  (int) (sdf.parse(dateEnd).getDay() - sdf.parse(dateBegin).getDay()) * new bikeModel(Integer.parseInt(bikeId)).getPayPerDay();
        paycheck = String.valueOf(result);
        System.out.println(paycheck);
    }

    public void delete(){
        String request = "DELETE FROM rents WHERE id = ?;";
        try{
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setInt(1, Integer.parseInt(id));
            int result = statement.executeUpdate();
        }
        catch (Exception e){

        }
    }

    private void setDateEndDb() throws Exception {
        String request = "UPDATE rents SET date_end = ? WHERE id = ?";
        try {
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setString(1, dateEnd);
            statement.setInt(2, Integer.parseInt(id));
        }
        catch (Exception e){

        }
    }
    private void setPaycheckDb() throws Exception {
        String request = "UPDATE rents SET paycheck = ? WHERE id = ?";
        try {
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setInt(1, Integer.parseInt(paycheck));
            statement.setInt(2, Integer.parseInt(id));
            int result = statement.executeUpdate();
        }
        catch (Exception e){

        }
    }
    private void setClientIdDb() throws Exception {
        String request = "UPDATE rents SET id_user  = ? WHERE id = ?";
        try {
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setInt(1, Integer.parseInt(clientId));
            statement.setInt(2, Integer.parseInt(id));
        }
        catch (Exception e){

        }
    }
    private void setBikeIdDb() throws Exception {
        String request = "UPDATE rents SET id_bike = ? WHERE id = ?";
        try {
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setInt(1, Integer.parseInt(bikeId));
            statement.setInt(2, Integer.parseInt(id));
        }
        catch (Exception e){

        }
    }
    private void setDateBeginDb() throws Exception {
        String request = "UPDATE rents SET date_begin = ? WHERE id = ?";
        try {
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setString(1, dateBegin);
            statement.setInt(2, Integer.parseInt(id));
        }
        catch (Exception e){

        }
    }
    public void add(){
        String request = "INSERT INTO rents(id_user, id_bike, date_begin) VALUES(?, ?, ?);";
        try{
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setInt(1, Integer.parseInt(clientId));
            statement.setInt(2, Integer.parseInt(bikeId));
            statement.setString(3, dateBegin);
            int result = statement.executeUpdate();
        }
        catch (Exception e){

        }
    }

    public String getId(){
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getDateBegin(){
        return dateBegin;
    }

    public String getDateEnd(){
        return  dateEnd;
    }

    public String getPaycheck(){
        return paycheck;
    }

    public void setClientId(String str) throws Exception{
        if(str.matches("[0-9]")){
            clientId = str;
            setClientIdDb();
        }
        else callError();
    }
    public void setBikeId(String str) throws Exception{
        if(str.matches("[0-9]")){
            bikeId = str;
            setBikeIdDb();
        }
        else callError();
    }
    public void setDateBegin(String str) throws Exception{
        if(dateCheck(str)) {
            dateBegin = str;
            setDateBeginDb();
        }
        else callError();
    }
    public void setDateEnd(String str) throws Exception{
        if(dateCheck(str)) {
            dateEnd = str;
            setDateEndDb();
        }
        else callError();
    }
    public void setPaycheck(String str) throws Exception{
        if(str.matches("[0-9]")) {
            paycheck = str;
            setPaycheckDb();
        }
        else {
            callError();
        }
    }
    private void callError(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.show();
    }
    private boolean dateCheck(String str){
        return str.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
    }
}
