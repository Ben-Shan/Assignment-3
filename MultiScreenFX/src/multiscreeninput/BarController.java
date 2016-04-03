package multiscreeninput;

import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BarController extends VisualController{


    
    /*@FXML
    private Pane visPane;*/
    
    @FXML
    HBox visHbox;
   
    //public HBox hbox;
    //private Rectangle rectangle;
    //private MainWindowController mainWindow;
    public Rectangle[] rects;
  
    @FXML
    void initialize() {
    	/*rectangle = new Rectangle(0, 0, 250, 250);
    	rectangle.setWidth(20);
    	rectangle.setHeight(100);
    	rectangle.setFill(Color.BLUE);
    	visPane.getChildren().add(rectangle);*/
    	
    	/*Not sure why mainWindow.getBands() wont work  
    	*/
    	//System.out.println("lol " + mainWindow.getBands());
    	
    	rects = new Rectangle[128];
    	for ( int i=0 ; i<rects.length; i++){
	    	rects[i] = new Rectangle();
	    	rects[i].setHeight(2);
	    	rects[i].setWidth(4);
	    	rects[i].setFill(Color.rgb((i*2),0,255-(i*2)));
	    	//visPane.getChildren().add(rects[i]);
	    	visHbox.setSpacing(2);
	    	visHbox.getChildren().add(rects[i]);
	    	System.out.println("yo " + i);
	    	//mainWindow.doAthing();
	    	//mainWindow.getLabelTextProperty();
	    }
    	
    }
    
    

   /* public void setMainWindow(MainWindowController mainWindow){
        super.mainWindow = mainWindow;
    }*/

    public void saveAndClose(ActionEvent event){
        // mainWindow.getLabelTextProperty().bind(text.textProperty());
        //((Button)event.getSource()).getScene().getWindow().hide();
       
    }
    
    public void update(){
    	
    	double[] mags = mainWindow.getMags();
    	
    	//System.out.println("in the update method" + date.toString());
    	
    	for ( int i=0 ; i<mags.length; i++){
	    	rects[i].setHeight(mags[i]*3);
    	}
     }
    
   /* public void runVis(){
    	int w = 1000;
    	int h = 200;
    	
    	visHbox.setMinWidth(1000);
    	
    	int bandWidth = w/mainWindow.getBands();
		
		
		
		for(Rectangle r:rects){
			r.setWidth(bandWidth);
			r.setHeight(2);
		}
		
		System.out.println("bandwidth is : " + bandWidth);
		
    }*/
}