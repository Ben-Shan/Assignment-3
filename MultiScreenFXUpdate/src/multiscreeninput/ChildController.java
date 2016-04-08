package multiscreeninput;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChildController {

	 @FXML
	 Button new_button;
	
    @FXML
    TextField text;

    @FXML
    Button savebtn;

    private MainWindowController mainWindow;


    public void setMainWindow(MainWindowController mainWindow){
        this.mainWindow = mainWindow;
    }

    public void saveAndClose(ActionEvent event){
        mainWindow.getLabelTextProperty().bind(text.textProperty());
        ((Button)event.getSource()).getScene().getWindow().hide();
    }
}