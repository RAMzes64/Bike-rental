package com.example.demo;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    protected void readTextArea(ActionEvent e) throws Exception{
        System.out.println(loginField.getText() + "\t" + passwordField.getText());
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
