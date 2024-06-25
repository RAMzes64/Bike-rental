package Controllers;

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

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class registrationController {
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
        String name, pass, pass2;
        int series = 0, number = 0;
        readName();
        readPassport();
        readPasswords();
        System.out.println(series + "\t" + number);
    }

    @FXML
    private void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean similiarPasswords(String pass, String pass2){
        return pass.equals(pass2);
    }

    private void readName(){
        try {
            System.out.println(nameField.getText());
        }
        catch (Exception e){

        }
    }

    private void readPasswords() throws Exception{
        try {
            String pass = passwordField.getText();
            String pass2 = passwordField2.getText();
            if (!similiarPasswords(pass, pass2)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Неверное заполнение полей");
                alert.setContentText("Пароли должны одинаковыми");
                alert.show();
            }
            System.out.println(pass +"\t" + pass2);
        }
        catch (Exception e){

        }
    }

    private void readPassport() throws Exception{
        try{
            int series = Integer.parseInt(seriesField.getText());
            int number = Integer.parseInt(numberField.getText());
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверное заполнение полей");
            alert.setContentText("Верно введите паспортные данные");
            alert.show();
        }
    }
}
