package application;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;



public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
		primaryStage.setTitle("Visualizer Menu");
		primaryStage.setScene(new Scene(root, 454,700));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
