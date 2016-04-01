package multiscreeninput;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
public File file = new File("src\\audio\\1.mp3");
public static File inputFile1;

	

    @Override
    public void start(Stage stage) throws Exception{

    	setFile(file);
    	
        Parent root = FXMLLoader.load(getClass().getResource("/multiscreeninput/MainWindow.fxml"));
        Scene scene = new Scene(root, 400, 200);
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
        System.out.println("file is : " + getFile());
    }
    
	public void setFile(File file){
		inputFile1 = file;
		
	}
	
	public static File getFile(){
		return inputFile1;
	}
	


    public static void main(String[] args) {
        launch(args);
    }
}