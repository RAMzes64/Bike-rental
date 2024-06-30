package Controllers;

import com.example.demo.booking;
import com.example.demo.rent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class bookingStaffController implements Initializable {

    @FXML
    private TableView<booking> bookingTable;
    @FXML
    private TableColumn<booking, String> idClm;
    @FXML
    private TableColumn<booking, String> clientIdClm;
    @FXML
    private TableColumn<booking, String> bikemodelClm;
    @FXML
    private TableColumn<booking, String> shopIdClm;
    @FXML
    private TableColumn<booking, String> dateClm;
    @FXML
    private TableColumn<booking, String> payClm;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }

    @FXML
    private void delete(){

    }

    @FXML
    private void switchToRent(ActionEvent event){
        idClm.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientIdClm.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        shopIdClm.setCellValueFactory(new PropertyValueFactory<>("idShopModel"));
        bikemodelClm.setCellValueFactory(new PropertyValueFactory<>("idBikeModel"));
        payClm.setCellValueFactory(new PropertyValueFactory<>("prepay"));
        dateClm.setCellValueFactory(new PropertyValueFactory<>("id"));


    }

    private void loadTable(){

    }
}
