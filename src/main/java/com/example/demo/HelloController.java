package com.example.demo;

import Controllers.bikeDescriptionController;
import Controllers.profileController;
import Models.DataBaseSingleton;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        /*
        DataBaseSingleton db = DataBaseSingleton.getInstance();

        System.out.println(loginField.getText() + "\t" + passwordField.getId());
        if(db.logIn(loginField.getText(), passwordField.getId())){
            switchToMainWindow(event);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Неверный пароль или логин");
            alert.show();
        }

         */
        switchToMainWindow(event);
    }

    @FXML
    protected void switchToMainWindow(ActionEvent event) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("mainWindow.fxml"));
            root = loader.load();

            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
         catch (Exception e) {
        }
    }
    @FXML
    private void switchToRegistration(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void readPassword(){
        System.out.print(passwordField.getText());
    }

    private void readName(){
        System.out.println(loginField.getText());
    }
}
