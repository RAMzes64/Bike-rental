package com.example.demo;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private String text;

    @FXML
    protected void readTextArea(ActionEvent e) throws Exception{
        System.out.println(loginField.getText() + "\t" + passwordField.getText());
    }
    }