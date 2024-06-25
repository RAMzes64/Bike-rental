package Controllers;

import Models.DataBaseSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class profileController extends MainWindowController{

    @FXML
    private TextField name;

    @FXML
    private TextField series;

    @FXML
    private TextField number;

    @FXML
    private TextField address;

    @FXML
    private TextField password1;

    @FXML
    private TextField password2;
    @FXML
    private void changeData(ActionEvent event){
        String[] strs = readTextFields();
        setTextFields(strs);
        //changeDB(strs,); Доделать
    }
    private boolean similarPasswords(String p1, String p2){
        if (p1.equals(p2)) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Пароли должны одинаковыми");
        alert.show();
        return false;
    }

    private boolean seriesCheck(String s){
        if (s.matches("^[0-9]{4}$")) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Правильно заполните серия паспорта");
        alert.show();
        return false;
    }

    private boolean numberCheck(String n){
        if (n.matches("^[0-9]{6}$")) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Правильно заполните номер паспорта");
        alert.show();
        return false;
    }

    private boolean addressCheck(String a){
        if (a.matches("^([А-ЯЁ][а-яё]+),\\s\\d{1,4},\\s\\d{1,5}$")) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Правильно заполните адрес");
        alert.show();
        return false;
    }

    private void setTextFields(String[] strs){
        name.setText(strs[0]);
        if (seriesCheck(strs[1])) series.setText(strs[1]);
        if (numberCheck(strs[2])) number.setText(strs[2]);
        if (addressCheck(strs[3])) address.setText(strs[3]);
        if (similarPasswords(strs[4], strs[5])){
            password1.setText(strs[4]);
            password2.setText(strs[5]);
        }
    }

    private String[] readTextFields(){
        String[] strs = new String[6];
        strs[0] = name.getText();
        strs[1] = series.getText();
        strs[2] = number.getText();
        strs[3] = address.getText();
        strs[4] = password1.getText();
        strs[5] = password2.getText();

        return strs;
    }

    private void changeDB(String[] strs, DataBaseSingleton db){

    }
}
