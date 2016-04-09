package application;


import javax.script.Bindings;

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
import javafx.scene.text.TextFlow;


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
	private Button selectButton;
	@FXML
	private Button selectImage;
	
	@FXML
	private TextField selectSongText;
	

	
	@FXML
	private ComboBox<String> combobox;
	
	@FXML
	private ColorPicker colorVisualiser;
	@FXML
	private ColorPicker colorBackground;

	


	@FXML
	private void initialize() {
	
		
	playButton.setOnAction((event) -> {
		System.out.println("Play");
	});
	
	selectButton.setOnAction((event) -> {
		selectSongText.appendText("Song Selected");
		

	});
	
	selectImage.setOnAction((event) -> {
		System.out.println("Image Selected");

	});
	
	colorVisualiser.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Visualiser:"+colorVisualiser.getValue());
	});
	
	colorBackground.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Background:"+colorBackground.getValue());
	});
			
	rgbRed.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Red" + newValue.intValue() );
	});
	
	rgbGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Green " + newValue.intValue());
	});
	
	rgbBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println("Blue" + newValue.intValue());
	});
	
	combobox.getItems().clear();

	combobox.getItems().addAll(
	            "Circle",
	            "Line",
	            "Box");
	
	combobox.valueProperty().addListener((observable, oldValue, newValue) -> {
	    System.out.println(combobox.getValue());
	});
	
	
	BooleanBinding booleanBind =(selectSongText.textProperty().isEmpty());
	playButton.disableProperty().bind(booleanBind);
	
	

	
	
	}

}