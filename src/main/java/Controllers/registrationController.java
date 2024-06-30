package Controllers;

import Models.Client;
import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class registrationController extends profileController {
    @FXML
    protected TextField nameField;

    @FXML
    protected TextField passwordField;

    @FXML
    private TextField passwordField2;

    @FXML
    protected TextField seriesField;

    @FXML
    protected TextField numberField;

    @FXML
    private void registration(ActionEvent event) throws Exception {
        try {
            String[] strs = readTextFields();
            setTextFields(strs);
            Client.registration(strs[0], strs[1]+strs[2], strs[4]);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Вы зарегистрированы");
            alert.show();
        }
        catch (Exception e){

        }
    }

    @FXML
    private void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    protected String[] readTextFields() {
        String[] strs = new String[6];
        strs[0] = nameField.getText();
        strs[1] = seriesField.getText();
        strs[2] = numberField.getText();
        strs[4] = passwordField.getText();
        strs[5] = passwordField2.getText();

        return strs;
    }

    @Override
    protected void setTextFields(String[] strs) {
        nameField.setText(strs[0]);
        if (seriesCheck(strs[1])) seriesField.setText(strs[1]);
        if (numberCheck(strs[2])) numberField.setText(strs[2]);
        if (similarPasswords(strs[4], strs[5])) {
            passwordField.setText(strs[4]);
            passwordField2.setText(strs[5]);
        }
    }
}