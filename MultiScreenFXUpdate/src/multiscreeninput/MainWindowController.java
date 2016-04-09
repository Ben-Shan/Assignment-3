package multiscreeninput;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import javafx.stage.FileChooser;


public class MainWindowController {

    @FXML
    Button button;

    @FXML
    Button displayBtn;
    
    @FXML
    CheckBox mp3Cb;
    
    @FXML
    CheckBox wavCb;
    
    @FXML
    Label label;
    
    @FXML
    Button fileSelectBtn;
    
    @FXML
    TextField fileLocTxtF;
    

    @FXML
    private Button updateBtn;

 
    private VisualDisplayController displayController; 
    
    
    
    public void openFileChooser(ActionEvent event) throws IOException {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("View Music");
    	fileChooser.setInitialDirectory(getMusicDirectory());
    	setFileExtensionFilter(fileChooser);
    	//FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
    	//fileChooser.getExtensionFilters().add(extFilter);
    	File file = fileChooser.showOpenDialog(fileSelectBtn.getScene().getWindow());
    	fileLocTxtF.setText(file.toString());
    	System.out.println(file);
    }
    
    private File getMusicDirectory(){
    	
    	//Set to Music directory or go to default if cannot access
    	String userDirectoryString = System.getProperty("user.home");
    	File musicDirectory = new File(userDirectoryString+"/Music");
    	if(!musicDirectory.canRead()) {
    	    musicDirectory = new File(userDirectoryString);
    	}
    	return musicDirectory;
    }
    
    private void setFileExtensionFilter(FileChooser fileChooser){    	
    	// Set extension filter   
    	if (mp3Cb.isSelected()){
    		FileChooser.ExtensionFilter extFilter = 
    			new FileChooser.ExtensionFilter("MP3 files (*.mp3)", "*.mp3");
    		fileChooser.getExtensionFilters().add(extFilter);
    	} if (wavCb.isSelected()) {
    		FileChooser.ExtensionFilter extFilter = 
    	         	new FileChooser.ExtensionFilter("WAV files (*.wav)", "*.wav");
    		fileChooser.getExtensionFilters().add(extFilter);
    	} else {
    		FileChooser.ExtensionFilter extFilter = 
    	         	new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
    		fileChooser.getExtensionFilters().add(extFilter);
    	}
    	
    	
    }
    
    
    public void openInputWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Child.fxml"));
        
        VBox newWindow = (VBox)loader.load();
        ChildController controller = loader.getController();
        controller.setMainWindow(this);
        
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(button.getScene().getWindow());
        Scene scene = new Scene(newWindow);
        
        stage.setScene(scene);
        stage.show();   
    }

    
    public void openDisplayWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VisualDisplay.fxml"));
        
        AnchorPane displayWindow = (AnchorPane)loader.load();
        displayController = loader.getController();
        //controller.setMainWindow(this);
        
        Stage stage = new Stage();
        stage.initModality(Modality.NONE);
        stage.initOwner(displayBtn.getScene().getWindow());
        Scene scene = new Scene(displayWindow);
        
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    void updateDisplay(ActionEvent event) {
    	int freq = new Integer (label.textProperty().toString());
    	//displayController.update(freq);
    }   
    
    
    public StringProperty getLabelTextProperty() {
        return label.textProperty();
    }
}