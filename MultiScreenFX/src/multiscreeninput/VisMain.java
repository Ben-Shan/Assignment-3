package multiscreeninput;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VisMain extends Application {
	

    @Override
    public void start(Stage stage) throws Exception{
 
    	Parent root = FXMLLoader.load(getClass().getResource("/multiscreeninput/application.fxml"));
    	stage.setTitle("Visualizer Menu");
    	stage.setScene(new Scene(root, 454,700));
    	stage.show();
    	
    	
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}