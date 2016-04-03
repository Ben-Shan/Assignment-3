package javaFXSoundTest;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class SoundMain extends Application {
	
	
	
	
	
	@Override
    public void start(Stage visStage) throws Exception{
				
		Parent visParent = FXMLLoader.load(getClass().getResource("Display.fxml"));
		Scene visScene = new Scene(visParent, 1000, 500, Color.rgb(255,0,0));	
		
		visStage.setTitle("Visualiser");
		visStage.setScene(visScene);
		visStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
}
