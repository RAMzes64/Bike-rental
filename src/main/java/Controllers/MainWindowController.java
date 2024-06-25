package Controllers;

import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("bikeDescription.fxml"));
        root = loader.load();

        bikeDescriptionController controller = loader.getController();
        controller.showLabel("123456");
        controller.showImage(whatImage(event));

        //root = FXMLLoader.load(HelloApplication.class.getResource("bikeDescription.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();;
    }

    private Image whatImage(Event event){
        String imageId = ((ImageView) event.getSource()).getId();
        if (imageId.equals("imageM1")) return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\mountain.png");
        else if (imageId.equals("imageM2")) return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\mountain2.png");
        else if (imageId.equals("imageR1")) return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\road1.png");
        else if (imageId.equals("imageR2")) return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\road2.png");
        else if (imageId.equals("imageT1")) return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\town1.png");
        else if (imageId.equals("imageT2")) return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\town2.png");
        else return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\profile.png");

    }

    @FXML
    private void switchToRent(ActionEvent event) throws Exception{
        //Надо переписать
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("rentView.fxml"));
        root = loader.load();

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
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("bookingView.fxml"));
        root = loader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToBikes(ActionEvent event) throws Exception{
        root = FXMLLoader.load(HelloApplication.class.getResource("mainWindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToProfile(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("profileView.fxml"));
        root = loader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToShops(ActionEvent event) throws Exception{
        //Надо дописать
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("shopsView.fxml"));
        root = loader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void exit(ActionEvent event) throws Exception{
        //Надо дописать
    }
}
