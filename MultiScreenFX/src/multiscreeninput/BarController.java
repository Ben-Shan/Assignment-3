package multiscreeninput;


import javafx.fxml.FXML;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class BarController extends VisualController{

    
    @FXML
    HBox visHbox;
   
    private Reflection reflection = new Reflection();

    public Rectangle[] rects;
    
    private double[] storedMags = new double[128];
  
    @FXML
    void initialize() {
    	
        Font.loadFont(
        	      BarController.class.getResource("Dense.otf").toExternalForm(), 
        	      18
        	    );
    	
    	rects = new Rectangle[128];
    	for ( int i=0 ; i<rects.length; i++){
	    	rects[i] = new Rectangle();
	    	rects[i].setHeight(3);
	    	rects[i].setWidth(6);
	    	rects[i].setFill(Color.rgb((i*2),255,255-(i*2)));
	    
	    	visHbox.setSpacing(2);
	    	visHbox.getChildren().add(rects[i]);
	    	System.out.println("yo " + i);
	    }
    	reflection.setFraction(0.5);
    	reflection.setTopOffset(5);
    }
    
    
    public void update(){
    	
    	double[] mags = mainWindow.getMags();
    	//System.out.println("stored mags : " + storedMags[1] + "new mags : " + mags[1]);
    	//System.out.println("in the update method" + date.toString());
    	
    	for ( int i=0 ; i<mags.length; i++){
    		rects[i].setFill(Color.web(mainWindow.getVisColour()));
    		double height = getNewHeight(mags[i],i);
    		//System.out.println("height is : " + height);
    		//System.out.println("mags are :  " + mags[i]);
    		rects[i].setHeight(height*5);
    		//rects[i].setHeight(mags[i]*7);
	    	rects[i].setEffect(reflection);
	    	storedMags[i] = mags[i];
    	}
     }
    
    //method to decay bars
    public double getNewHeight(double newMag, int i){
    	double difference = 0;
    	if(newMag < storedMags[i]){
    		//System.out.println("yo int the thinkg " + newMag + "   " + storedMags[i]);
    		difference = storedMags[i] - newMag;
    		difference = difference/2;
    		return (storedMags[i] - difference);
    	}
    	else{
    		return newMag;
    	}
    }

}