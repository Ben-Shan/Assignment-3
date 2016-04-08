package multiscreeninput;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/multiscreeninput/MainWindow.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }
  
     

    public static void main(String[] args) {
        launch(args);
    }
}