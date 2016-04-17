package multiscreeninput;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleController extends VisualController {

    @FXML
    HBox visHbox;
    
    @FXML
    StackPane visPane;
    
    public Circle[] circles;
    
    @FXML
    void initialize(){
    	
    	circles = new Circle[128];
    	for(int i = 0; i<circles.length; i++){
    		circles[i] = new Circle();
    		circles[i].setStroke(Color.rgb((i%25)* 10, 255-((i%25)* 10), (i%25)* 10));
    		circles[i].setRadius(20);
    		circles[i].setFill(Color.TRANSPARENT);
    		System.out.println("circle initialize " + i);
    		visPane.getChildren().add(circles[i]);
    	}
    }
	
	public void update() {
		double[] mags = mainWindow.getMags();
		double[] phases = mainWindow.getPhase();
		
		for ( int i=0 ; i<mags.length; i++){
	    	circles[i].setRadius(mags[i]*10);
	    	circles[i].setStrokeWidth((phases[i]+1));
	    	circles[i].setStroke(Color.web(mainWindow.getVisColour()));
	    	//System.out.println("the phase is : " + phases[i]);
    	}
	}
}
