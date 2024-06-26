package Controllers;

import Models.DataBaseSingleton;
import Models.bikeModel;
import Models.shop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class bookingController extends MainWindowController implements Initializable {

    private DataBaseSingleton db;

    @FXML
    private ChoiceBox<String> shopMenuBtn;

    @FXML
    private DatePicker dateBtn;

    @FXML
    private Button bookingBtn;

    private bikeModel bikeModel;

    //private ArrayList<String> shops;
    private String[] shops = {"1", "2", "3"};
    private void getModel(bikeModel model){
        bikeModel = model;
    }

    @FXML
    private void toBook(ActionEvent event){
        System.out.println(shopMenuBtn.getValue() + "\t" + getDate(event));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*
        try {
            for (shop s : shop.getAllShops(db)) {
                shops.add(s.getName());
            }
        }
        catch (SQLException e){

        }
         */
        shopMenuBtn.getItems().addAll(shops);
        //shops.toArray(new String[shops.size()])
    }

    private String getDate(ActionEvent event){
        return dateBtn.getValue().toString();
    }
}
