package Controllers;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class bookingController extends MainWindowController implements Initializable {

    @FXML
    private ChoiceBox<String> shopMenuBtn;

    @FXML
    private DatePicker dateBtn;

    @FXML
    private Button bookingBtn;

    private bikeModel bikeModel;

    private PreparedStatement statement;

    private Client client;

    private HashMap<String, Integer> shopMap = new HashMap<>();

    @FXML
    public void toBook(ActionEvent event) throws Exception {
        shopMap = getAllshops();
        String dateStr = getDate(event);
        if (checkDate(dateStr))
        System.out.println(shopMenuBtn.getValue() + "\t" + dateStr + "\t" + bikeModel.getId());
        //bookingDB(getDate(event), client.getId(), getIdShopModel(getShopId(shopMenuBtn.getValue()), bikeModel.getId()));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] str = {"12", "23", "34", "45"};
        shopMenuBtn.getItems().addAll(str);
        //shopMenuBtn.getItems().addAll(getNameAddressShops());
    }

    private String getDate(ActionEvent event){
        return dateBtn.getValue().toString();
    }
    public void setModel(bikeModel b){
        bikeModel = b;
    }

    private void bookingDB(String date, int idC, int idShopModel){
        String request = "INSERT INTO booking(id_user, id_shop_model, date, prepay) VALUES (?, ?, CONVERT( DATE, ?, 10), ?);";

        try{
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
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

    private HashMap<String, Integer> getAllshops(){
        HashMap<String, Integer> map = new HashMap<>();
        String request = "SELECT ?, ?, ? FROM ?";
        try{
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setString(1, "id");
            statement.setString(2, "name");
            statement.setString(3, "address");
            statement.setString(4, "shops");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                map.put(resultSet.getString(2) + "\t" + resultSet.getString(3), resultSet.getInt(1));
            }

            if(statement != null) statement.close();
            if(resultSet != null) resultSet.close();
        }
        catch (Exception e){

        }
        return map;
    }

    private int getIdShopModel(int idShop, int idModel){
        String request = "SELECT ? FROM ? WHERE id_shop = ? AND id_model = ?;";
        int idShopModel = 0;
        try{
            statement = DataBaseSingleton.getConnection().prepareStatement(request);
            statement.setString(1, "id");
            statement.setString(2, "shop_models");
            statement.setInt(3, idShop);
            statement.setInt(4, idModel);

            ResultSet resultSet = statement.executeQuery();
            idShopModel = resultSet.getInt(1);

            if(statement != null) statement.close();
            if(resultSet != null) resultSet.close();
        }
        catch (Exception e){

        }
        return idShopModel;
    }

    public void setClient(Client c){
        client = c;
    }

    private String[] getNameAddressShops(){
        return (String[]) shopMap.keySet().toArray();
    }

    private int getShopId(String str){
        return shopMap.get(str);
    }

    private boolean checkDate(String dateStr) throws Exception {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        int result = Calendar.getInstance().getTime().compareTo(date);

        if (result < 0) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Неверная дата");
        alert.show();
        return false;
    }
}
