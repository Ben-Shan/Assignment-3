package multiscreeninput;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainWindowController {

    @FXML
    Button button;

    @FXML
    Label label;
    
    @FXML
    Slider slider;

    private int bands;
    private ChildController childController;
    //private File inputFile;
    
    public void openInputWindow(ActionEvent event) throws IOException {
    	
    	System.out.println("should play : " + Main.getFile());
    	
    	//change the file to a URI
    	String fileURI = Main.getFile().toURI().toString();
    	System.out.println("the file URI is : " + fileURI);
    	
    	Media media = new Media(fileURI);
    	
    	MediaPlayer player = new MediaPlayer(media);
	    MediaView view = new MediaView(player);
    	
	    bands = player.getAudioSpectrumNumBands();
	    final double[] bandArr = new double[bands];
	    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Child.fxml"));
        VBox newWindow = (VBox)loader.load();
        childController = loader.getController();
        childController.setMainWindow(this);
        Stage stage = new Stage();
        //stage.initModality(Modality.NONE);
        stage.initOwner(button.getScene().getWindow());
        Scene scene = new Scene(newWindow);
        stage.setScene(scene);
        stage.show();   
        //stage.setFullScreen(true);
        //player.play();
        
        //newWindow.getChildren().add(controller.update());
        
        //controller.update();
        //controller.runVis();
        
        
      /*  player.setOnReady(new Runnable(){
        	@Override
        	public void run(){
        	
        		controller.runVis();
        		System.out.println("its doing the run");
        		
        		slider.setMin(0.0);
	    		slider.setValue(0.0);
	    		slider.setMax(player.getTotalDuration().toSeconds());
        		
        	}
        	
        });*/
        
        /*player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration current) {
                slider.setValue(current.toSeconds());
            }
        });
        
        slider.setOnMouseClicked(new EventHandler<MouseEvent>(){
	    	@Override 
	    	public void handle(MouseEvent mouseEvent){
	    		player.seek(Duration.seconds(slider.getValue()));
	    	}
	    });*/
        
        
        
        
        
        
        player.setAudioSpectrumListener(new AudioSpectrumListener() {
            @Override
            public void spectrumDataUpdate(double v, double v1, float[] mags, float[] floats1) {
            	for( int i=0; i<bands; i++){
            		double magnitude = mags[i]+60;
            		
            		if(magnitude>1){
            			bandArr[i] = magnitude;
            		}
            		if(magnitude<1){
            			bandArr[i] = 2;
            		}
            		//System.out.println(bandArr[i]);
            	}
            }            
	    });
    }
    
    @FXML
    void initialize(){
    	new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                if(childController != null){
                	childController.update();
                }
                
            }
        }.start();
    }
    
   /* public void handle(long currentNanoTime)
    {
    	System.out.println("in the handle");
        childController.update();
    }*/
    

    public int getBands(){
    	return bands;
    }
        
    public StringProperty getLabelTextProperty() {
        return label.textProperty();
    }
}