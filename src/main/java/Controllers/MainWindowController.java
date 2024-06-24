package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowController {

    private Stage stage;

    private Parent root;

    private Scene scene;

    protected void switchToBikeDescription(ActionEvent event) throws Exception{
        //Надо переписать
        root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void switchToRent(ActionEvent event) throws Exception{
        //Надо переписать
        root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void switchToBooking(ActionEvent event) throws Exception{
        //Надо дописать
    }

    protected void switchToBikes(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    protected void switchToProfile(ActionEvent event) throws Exception{
        //Надо дописать
    }

    protected void switchToShops(ActionEvent event) throws Exception{
        //Надо дописать
    }

    protected void exit(ActionEvent event) throws Exception{
        //Надо дописать
    }
}
