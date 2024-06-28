package Controllers;

import Models.Client;
import Models.DataBaseSingleton;
import Models.bikeModel;
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
import java.sql.Connection;
import java.sql.SQLException;

public class MainWindowController {

    private Stage stage;

    private Parent root;

    private Scene scene;

    private Client client;

    protected Connection conn;

    @FXML
    protected void switchToBikeDescription(MouseEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("bikeDescription.fxml"));
        root = loader.load();

        bikeDescriptionController controller = loader.getController();
        controller.showLabel("123456");
        controller.showImage(whatImage(event));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private Image whatImage(Event event) {
        String imageId = ((ImageView) event.getSource()).getId();
        if (imageId.equals("imageM1"))
            return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\mountain.png");
        else if (imageId.equals("imageM2"))
            return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\mountain2.png");
        else if (imageId.equals("imageR1"))
            return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\road1.png");
        else if (imageId.equals("imageR2"))
            return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\road2.png");
        else if (imageId.equals("imageT1"))
            return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\town1.png");
        else if (imageId.equals("imageT2"))
            return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\bicycle\\town2.png");
        else return new Image("C:\\University\\1.2\\Course\\demo\\src\\main\\resources\\Images\\profile.png");

    }

    @FXML
    private void switchToBooking(ActionEvent event) throws Exception {
        //Надо дописать
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("bookingView.fxml"));
        root = loader.load();

        bookingController controller = loader.getController();
        controller.setModel(whatModel(event));
        controller.setClient(client);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToBikes(ActionEvent event) throws Exception {
        root = FXMLLoader.load(HelloApplication.class.getResource("mainWindow.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToProfile(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("profileView.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToShops(ActionEvent event) throws Exception {
        //Надо дописать
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("shopsView.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void exit(ActionEvent event) throws Exception {
        //Надо дописать
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private bikeModel whatModel(ActionEvent event) throws SQLException {
        try {
            String id = ((ImageView) event.getSource()).getId();
            if (id.equals("bookBtn1")) return new bikeModel(1);
            else if (id.equals("bookBtn2")) return new bikeModel(2);
            else if (id.equals("bookBtn3")) return new bikeModel(3);
            else if (id.equals("bookBtn4")) return new bikeModel(4);
            else if (id.equals("bookBtn5")) new bikeModel(5);
            return new bikeModel(6);
        } catch (Exception e) {

        }
        return new bikeModel(1);
    } // Доделать, когда sql заработает

    public void setClient(Client c){
        client = c;
    }
}
