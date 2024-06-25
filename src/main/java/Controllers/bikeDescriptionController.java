package Controllers;

import Controllers.MainWindowController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class bikeDescriptionController extends MainWindowController {
    @FXML
    private ImageView image;

    @FXML
    public void showImage(ImageView image){
        this.image.setImage(image.getImage());
    }
}
