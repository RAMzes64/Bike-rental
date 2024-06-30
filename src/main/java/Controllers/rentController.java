package Controllers;

import Models.Client;
import Models.DataBaseSingleton;
import com.example.demo.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellEditEvent;
import com.example.demo.rent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class rentController implements Initializable {

    @FXML
    private TableView<rent> rentTable;
    @FXML
    private TableColumn<rent, String> idClm;
    @FXML
    private TableColumn<rent, String> clientIdClm;
    @FXML
    private TableColumn<rent, String> bikeIdClm;
    @FXML
    private TableColumn<rent, String> dateBeginClm;
    @FXML
    private TableColumn<rent, String> dateEndClm;
    @FXML
    private TableColumn<rent, String> paycheckClm;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button changeBtn;
    @FXML
    private Button addBtn;
    @FXML
    private TextField idField;
    @FXML
    private TextField clientIdField;
    @FXML
    private TextField bikeIdField;
    @FXML
    private TextField paycheckField;
    @FXML
    private DatePicker dateBeginPick;
    @FXML
    private DatePicker dateEndPick;

    ObservableList<rent> rents = FXCollections.observableArrayList();
    private rent r;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idClm.setCellValueFactory(new PropertyValueFactory<rent, String>("id"));
        clientIdClm.setCellValueFactory(new PropertyValueFactory<rent, String>("clientId"));
        bikeIdClm.setCellValueFactory(new PropertyValueFactory<rent, String>("bikeId"));
        dateBeginClm.setCellValueFactory(new PropertyValueFactory<rent, String>("dateBegin"));
        dateEndClm.setCellValueFactory(new PropertyValueFactory<rent, String>("dateEnd"));
        paycheckClm.setCellValueFactory(new PropertyValueFactory<rent, String>("paycheck"));
        try {
            rentTable.setItems(getRents());
        }
        catch (Exception e){

        }
        rentTable.setEditable(true);
        clientIdClm.setCellFactory(TextFieldTableCell.forTableColumn());
        bikeIdClm.setCellFactory(TextFieldTableCell.forTableColumn());//
        dateBeginClm.setCellFactory(TextFieldTableCell.forTableColumn());
        dateEndClm.setCellFactory(TextFieldTableCell.forTableColumn());
        paycheckClm.setCellFactory(TextFieldTableCell.forTableColumn());//

    }

    private ObservableList<rent> getRents() throws Exception{
        String request = "SELECT * FROM rents;";
        PreparedStatement statement = DataBaseSingleton.getConnection().prepareStatement(request);
        ResultSet r = statement.executeQuery();
        while(r.next()){
            rents.add(new rent(r.getString(1), r.getString(2), r.getString(3), r.getString(4)));
            System.out.println(rents.get(rents.size() -1).getId());
        }

        return rents;
    }


    private String getDateBegin(){
        return dateBeginPick.getValue().toString();
    }

    private String getDateEnd(){
        return dateEndPick.getValue().toString();
    }

    @FXML
    private void deleteDataRow(ActionEvent event){
        ObservableList<rent> allRents, singleRent;
        allRents = rentTable.getItems();
        singleRent = rentTable.getSelectionModel().getSelectedItems();

        System.out.println(allRents.get(0).getId());
        singleRent.get(0).delete();
        singleRent.forEach(allRents::remove);
    }

    @FXML
    private void addDataRow(ActionEvent event){
        try {
            rents.add(new rent( clientIdField.getText().toString(), bikeIdField.getText().toString(), dateBeginPick.getValue().toString()));
            System.out.println(r.getPaycheck());
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверное заполнение полей");
            alert.show();
        }
        try {
            rents.get(rents.size() - 1).add();
        }
        catch (Exception e){

        }
        rentTable.refresh();
    }

    @FXML
    private void setPaycheck(ActionEvent event){
        rent r =  rentTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void changeClientId(CellEditEvent edittedCell) throws Exception {
        rent r =  rentTable.getSelectionModel().getSelectedItem();
        r.setClientId(edittedCell.getNewValue().toString());
    }

    @FXML
    private void changeBikeId(CellEditEvent edittedCell) throws Exception {
        rent r =  rentTable.getSelectionModel().getSelectedItem();
        r.setBikeId(edittedCell.getNewValue().toString());
    }

    @FXML
    private void changeDateBegin(CellEditEvent edittedCell) throws Exception {
        rent r =  rentTable.getSelectionModel().getSelectedItem();
        r.setDateBegin(edittedCell.getNewValue().toString());
    }

    @FXML
    private void changeDateEnd(CellEditEvent edittedCell) throws Exception {
        rent r =  rentTable.getSelectionModel().getSelectedItem();
        r.setDateEnd(edittedCell.getNewValue().toString());
        r.setPaycheck();
        r.setPaycheck(edittedCell.getNewValue().toString());
    }

    @FXML
    private void changePaycheck(CellEditEvent edittedCell) throws Exception {
        rent r =  rentTable.getSelectionModel().getSelectedItem();
        r.setPaycheck();
        r.setPaycheck(edittedCell.getNewValue().toString());
    }

    @FXML
    private void switchToBooking(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("bookingStaffView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
