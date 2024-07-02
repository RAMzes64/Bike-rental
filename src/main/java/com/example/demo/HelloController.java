package com.example.demo;

import Controllers.bikeDescriptionController;
import Controllers.*;
import Models.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController extends profileController {
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    protected void readTextArea(ActionEvent event) throws Exception {
        User user = logIn(loginField.getText(), passwordField.getId());
        if(user.getClass() == Client.class){
            switchToMainWindow(event);
        }
        else if (user.getClass() == staff.class){
            switchToRent(event);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Неверный пароль или логин");
            alert.show();
        }
    }

    @FXML
    protected void switchToMainWindow(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("mainWindow.fxml"));
            root = loader.load();

            MainWindowController controller = loader.getController();


            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    private void switchToRent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("rentView.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    private void switchToRegistration(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("registration.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static User logIn(String name, String password) throws SQLException {//Надо переписать
        PreparedStatement statement = null;

        try {
            statement = DataBaseSingleton.getConnection().prepareStatement("SELECT id, name, aes_decrypt(password, 'key'), access FROM users WHERE name = ? AND password = ?");
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getInt(4) == 2) {
                    return new staff();
                } else if (resultSet.getInt(4) == 3) {

                } else return new Client(resultSet.getInt(1));
            }
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        } catch (Exception e) {

        }
        return new User();
    }
}
