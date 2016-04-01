package javaFXsound;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Visuals {

	@FXML
	Button playButton;
	
	public void openVisualiser(ActionEvent event) throws Exception{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaFXsound/VisualiserWindow.fxml"));
		VBox newWindow = (VBox)loader.load();
		BarVis barVis = loader.getController();
		barVis.setMainWindow(this);
		Stage stage1 = new Stage();
		
		stage1.initModality(Modality.WINDOW_MODAL);
		stage1.initOwner(playButton.getScene().getWindow());
		
		Scene scene = new Scene(newWindow);
		
		stage1.setScene(scene);
        stage1.show(); 
	}
	
	
	
		

}
