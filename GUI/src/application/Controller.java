package application;


import java.io.File;
import java.io.IOException;

import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;


public class Controller {
	
	@FXML
	private Slider rgbRed;
	@FXML
	private Slider rgbGreen;
	@FXML
	private Slider rgbBlue;
	
	@FXML
	private Button playButton;
	@FXML
	private Button songButton;
	@FXML
	private Button imageButton;
	
	@FXML
	private TextField selectSongText;
	
	@FXML
	private Label imageLabel;
	
	@FXML
	private ComboBox<String> combobox;
	
	@FXML
	private ColorPicker colorVisualiser;
	@FXML
	private ColorPicker colorBackground;

	private String visualiserColour = "0xffffffff";
	
	private String visType;
	
	private String fileURI;
	private File backgroundFile;


	@FXML
	private void initialize() {
	
		
	playButton.setOnAction((event) -> {
		System.out.println("Play");
	});
	
	/*selectButton.setOnAction((event) -> {
		selectSongText.appendText("Song Selected");
		
	});*/
	
	/*imageButton.setOnAction((event) -> {
		System.out.println("Image Selected");

	});*/
	
	colorVisualiser.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Visualiser:"+colorVisualiser.getValue());
	    visualiserColour=colorVisualiser.getValue().toString();
	    System.out.println("yo skrill" + getVisCoulour());
	    
	});
	
	colorBackground.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Background:"+colorBackground.getValue());
	});
			
	/*rgbRed.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Red" + newValue.intValue() );
	});
	
	rgbGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Green " + newValue.intValue());
	});
	
	rgbBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Blue" + newValue.intValue());
	});*/
	
	combobox.getItems().clear();

	combobox.getItems().addAll(
	            "Circle",
	            "Line",
	            "Box");
	
	combobox.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println(combobox.getValue());
	    visType= combobox.getValue();
	    System.out.println("ger away ouda dat" + getVisType());
	});
	
	
	BooleanBinding booleanBind =(selectSongText.textProperty().isEmpty());
	playButton.disableProperty().bind(booleanBind);
	
	}

	public void openSongChooser(ActionEvent event) throws IOException {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("View Music");
    	fileChooser.setInitialDirectory(getMusicDirectory());
    	//might add a filter to only accept certain file extentions 
    	//setFileExtensionFilter(fileChooser);
    	File file = fileChooser.showOpenDialog(imageButton.getScene().getWindow());
    	selectSongText.setText(file.toString());
    	//songFile = file;
    	System.out.println("the song yo selected be " + file);
    	fileURI = file.toURI().toString();
    	System.out.println("the song URI be " + getSongFile());
    	
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
	
	public void openImageChooser(ActionEvent event) throws IOException{
		FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Select Image");
    	//fileChooser.setInitialDirectory(getMusicDirectory());
    	//might add a filter to only accept certain file extentions 
    	//setFileExtensionFilter(fileChooser);
    	File file = fileChooser.showOpenDialog(songButton.getScene().getWindow());
    	//selectSongText.setText(file.toString());
    	imageLabel.setText(file.toString());
    	System.out.println(file);
	}
	
	public String getVisCoulour(){
		return visualiserColour;
	}
<<<<<<< HEAD

}
=======
	
	public String getVisType(){
		return visType;
	}
	
	public String getSongFile(){
		return fileURI;
	}
	
}


>>>>>>> 7bd669ff97c402230a00fdaca9b69a7e8a60f782
