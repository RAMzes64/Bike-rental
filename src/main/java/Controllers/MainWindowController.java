package Controllers;

import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    private Stage stage;

    private Parent root;

    private Scene scene;

    private ImageView bikeImage;

    @FXML
    protected void switchToBikeDescription(MouseEvent event) throws Exception{
        bikeImage = whatImage(event);
        FXMLLoader loader= FXMLLoader.load(HelloApplication.class.getResource("bikeDescription.fxml"));
        root = loader.load();

        bikeDescriptionController controller = loader.getController();
        controller.showImage(whatImage(event));

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private ImageView whatImage(Event event){
        String imageId = ((ImageView) event.getSource()).getId();
        //if (imageId.equals("imageM1")) return new ImageView("\"C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\mountain.png\"");
        return new ImageView("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\mountain.png");/*
        else if (imageId.equals("imageM2")) return new ImageView("\"C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\mountain2.png\"");
        else if (imageId.equals("imageR1")) return new ImageView("\"C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\road1.png\"");
        else if (imageId.equals("imageR2")) return new ImageView("\"C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\road2.png\"");
        else if (imageId.equals("imageT1")) return new ImageView("\"C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\town1.png\"");
        else if (imageId.equals("imageT2")) return new ImageView("\"C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\town2.png\"");
        else return new ImageView();
        */
    }

    @FXML
    private void switchToRent(ActionEvent event) throws Exception{
        //Надо переписать
        root = FXMLLoader.load(getClass().getResource("rentView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void switchToExample(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("exampleView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void switchToBooking(ActionEvent event) throws Exception{
        //Надо дописать
    }

    @FXML
    protected void switchToBikes(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToProfile(ActionEvent event) throws Exception{
        //Надо дописать
    }

    @FXML
    protected void switchToShops(ActionEvent event) throws Exception{
        //Надо дописать
    }

    @FXML
    protected void exit(ActionEvent event) throws Exception{
        //Надо дописать
    }
}
