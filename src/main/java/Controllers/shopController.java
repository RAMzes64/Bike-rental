package Controllers;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import Models.*;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class shopController extends MainWindowController implements Initializable {

    @FXML
    private TableColumn<shop, String> nameT;

    @FXML
    private TableColumn<shop, String> addressT;

    PreparedStatement s = null;

    ResultSet r = null;

    ObservableList<shop> shopList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
