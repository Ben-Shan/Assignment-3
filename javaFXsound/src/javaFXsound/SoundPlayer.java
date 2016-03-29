package javaFXsound;

import java.io.File;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.AudioSpectrumListener;
import javafx.util.Duration;


public class SoundPlayer extends Application {
	
	private File inputFile1;
	private Media media;

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		//setting the title of the player at the top
		stage.setTitle("Music Player");
		//creating a group node called root
		Group root = new Group();
		
	
		//setting the file path
	    try{
	    	inputFile1 = new File("src\\audio\\Alarm Beat.mp3");
	    
			//converting the file path to a URI so media can read it
			String fileURI = inputFile1.toURI().toString();
			System.out.println("the URI is " + inputFile1);
	    	
			media = new Media(fileURI);
	    }catch (Exception e) {
            //e.printStackTrace();
	    	//if the file can't be found it will play an error sound.
            System.out.println("the file is not found");
            inputFile1 = new File("src\\audio\\Error.mp3");
            String fileURI = inputFile1.toURI().toString();
            media = new Media(fileURI);
            //System.exit(1);
        }
	    
	    
	    MediaPlayer player = new MediaPlayer(media);
	    MediaView view = new MediaView(player);
	    
	    /*
	     * set the slide in and slide out functions of the player when 
	     * mouse is over the player
	     */
	    final Timeline slideIn = new Timeline();
	    final Timeline slideOut = new Timeline();
	    root.setOnMouseExited(new EventHandler<MouseEvent>(){
	    	@Override
	    	public void handle(MouseEvent mouseEvent){
	    		//slideOut.play();
	    	}
	    });
	    
	    root.setOnMouseEntered(new EventHandler<MouseEvent>(){
	    	@Override
	    	public void handle(MouseEvent mouseEvent){
	    		//slideIn.play();
	    	}
	    });
	    
	    final VBox vbox = new VBox();
	    final Slider slider = new Slider();
	    
	    final HBox hbox = new HBox(2);
	    final int bands = player.getAudioSpectrumNumBands();
	    final Rectangle[] rects = new Rectangle[bands];
	    
	    for ( int i=0 ; i<rects.length; i++){
	    	rects[i] = new Rectangle();
	    	rects[i].setFill(Color.rgb(255,255,255));
	    	hbox.getChildren().add(rects[i]);
	    }
	    vbox.getChildren().add(slider);
	    vbox.getChildren().add(hbox);
	    
	    root.getChildren().add(view);
	    root.getChildren().add(vbox);
	    
	    Scene scene = new Scene(root, 650, 600, Color.rgb(0,0,0));
	    stage.setScene(scene);
	    stage.show();
	    stage.setFullScreen(true);
	    player.play();
	    
	    player.setOnReady(new Runnable(){
	    	@Override
	    	public void run(){
	    		int w = 1000;
	    		int h = 50;
	    		//int w = player.getMedia().getWidth();
	    		//int h = player.getMedia().getHeight();
	    		
	    		hbox.setMinWidth(w);
	    		int bandWidth = w/rects.length;
	    		for(Rectangle r:rects){
	    			r.setWidth(bandWidth);
	    			r.setHeight(2);
	    		}
	    		
	    		stage.setMinWidth(w);
	    		stage.setMinHeight(h);
	    		
	    		vbox.setMinSize(w, 100);
	    		vbox.setTranslateY(h-50);
	    		
	    		slider.setMin(0.0);
	    		slider.setValue(0.0);
	    		slider.setMax(player.getTotalDuration().toSeconds());
	    		
	    		slideOut.getKeyFrames().addAll(
	    				new KeyFrame(new Duration(0),
	    						new KeyValue(vbox.translateYProperty(), h-100),
	    						new KeyValue(vbox.opacityProperty(), 0.9)
	    						),
	    				new KeyFrame(new Duration(300),
	    						new KeyValue(vbox.translateYProperty(), h),
	    						new KeyValue(vbox.opacityProperty(), 0.0)
	    						)
	    		);
	    		
	    		slideIn.getKeyFrames().addAll(
	    				new KeyFrame(new Duration(0),
	    						new KeyValue(vbox.translateYProperty(), h),
	    						new KeyValue(vbox.opacityProperty(), 0.0)
	    						),
	    				new KeyFrame(new Duration(300),
	    						new KeyValue(vbox.translateYProperty(), h-100),
	    						new KeyValue(vbox.opacityProperty(), 0.9)
	    						)
	    		);
	    	}
	    });
	    
	    player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
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
	    });
	    
	    player.setAudioSpectrumListener(new AudioSpectrumListener() {
            @Override
            public void spectrumDataUpdate(double v, double v1, float[] mags, float[] floats1) {
            	for( int i=0; i<rects.length; i++){
            		double h = mags[i]+60;
            		if(h>2){
            			rects[i].setHeight(h);
            		}
            	}
            }
	    });
	}
}




