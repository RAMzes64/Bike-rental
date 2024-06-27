package Controllers;

import Models.DataBaseSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class profileController extends MainWindowController{

    @FXML
    protected TextField name;

    @FXML
    protected TextField series;

    @FXML
    protected TextField number;

    @FXML
    private TextField address;

    @FXML
    protected TextField password1;

    @FXML
    protected TextField password2;
    @FXML
    private void changeData(ActionEvent event){
        try {
            String[] strs = readTextFields();
            setTextFields(strs);
            //changeDB(strs,); Доделать
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Что-то не так");
            alert.show();
        }
    }
    protected boolean similarPasswords(String p1, String p2){
        if (p1.equals(p2)) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Пароли должны одинаковыми");
        alert.show();
        return false;
    }

    protected boolean seriesCheck(String s){
        if (s.matches("^[0-9]{4}$")) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Правильно заполните серия паспорта");
        alert.show();
        return false;
    }

    protected boolean numberCheck(String n){
        if (n.matches("^[0-9]{6}$")) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Правильно заполните номер паспорта");
        alert.show();

        return false;
    }

    protected boolean passwordCheck(String p){
        if(p.matches("^{,8}$")) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Слишком длинный пароль");
        alert.show();

        return false;
    }

    protected boolean addressCheck(String a){
        if (a.matches("^([А-ЯЁ][а-яё]+),\\s\\d{1,4},\\s\\d{1,5}$")) return true;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неверное заполнение полей");
        alert.setContentText("Правильно заполните адрес");
        alert.show();
        return false;
    }

    protected void setTextFields(String[] strs){
        name.setText(strs[0]);
        if (seriesCheck(strs[1])) series.setText(strs[1]);
        if (numberCheck(strs[2])) number.setText(strs[2]);
        if (addressCheck(strs[3])) address.setText(strs[3]);
        if (similarPasswords(strs[4], strs[5]) && passwordCheck(strs[4])){
            password1.setText(strs[4]);
            password2.setText(strs[5]);
        }
    }

    protected String[] readTextFields(){
        String[] strs = new String[6];
        strs[0] = name.getText();
        strs[1] = series.getText();
        strs[2] = number.getText();
        strs[3] = address.getText();
        strs[4] = password1.getText();
        strs[5] = password2.getText();

        return strs;
    }
}
