package Controllers;

import Controllers.MainWindowController;
import com.example.demo.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class bikeDescriptionController extends MainWindowController {
    @FXML
    private ImageView image;

    @FXML
    private Label label;

    @FXML
    public void showImage(Image img){
        image.setImage(img);
    }

    @FXML
    public void showLabel(String str){
        label.setText(str);
    }
}
