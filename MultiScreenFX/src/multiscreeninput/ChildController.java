package multiscreeninput;

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

public class ChildController {

    @FXML
    TextField text;

    @FXML
    Button button;
    
    @FXML
    private Pane visPane;
    
    @FXML
    HBox visHbox;
    
    /*@FXML
    Slider slider;*/
    
    public Rectangle[] rects;
    //public HBox hbox;
    private Rectangle rectangle;
    private MainWindowController mainWindow;
    private int i = 0;
    @FXML
    void initialize() {
    	rectangle = new Rectangle(0, 0, 250, 250);
    	/*rectangle.setWidth(20);
    	rectangle.setHeight(100);*/
    	rectangle.setFill(Color.BLUE);
    	visPane.getChildren().add(rectangle);
    	
    }

    public void setMainWindow(MainWindowController mainWindow){
        this.mainWindow = mainWindow;
    }

    public void saveAndClose(ActionEvent event){
       // mainWindow.getLabelTextProperty().bind(text.textProperty());
        //((Button)event.getSource()).getScene().getWindow().hide();
       
    }
    
    public void update(){
    	//final HBox hbox = new HBox(1);
    	
    	/*final Rectangle[] rects = new Rectangle[mainWindow.getBands()];
    	for ( int i=0 ; i<rects.length; i++){
	    	rects[i] = new Rectangle();
	    	rects[i].setFill(Color.rgb(255,0,255));
	    	visHbox.getChildren().add(rects[i]);
	    }*/
    	    	
    	//vbox.getChildren().add(hbox);
    	System.out.println("in the update method");
    	/*if(i>254){
    		i--;
    		int j = 150;
    		rectangle.setFill(Color.rgb(i, j, 0));
    		
    	}
    	if(i<1){
    		rectangle.setFill(Color.rgb(i, 0, 0));
    		i++;
    	}*/
    	
    	if(i < 120){
    		System.out.println("i is : " + i);
    		rectangle.setFill(Color.RED);
    		i++;
    	}
    	
    	else{
    		rectangle.setFill(Color.BLUE);
    		i++;
    	}
     }
    
    public void runVis(){
    	int w = 1000;
    	int h = 200;
    	
    	visHbox.setMinWidth(1000);
    	
    	int bandWidth = w/mainWindow.getBands();
		
		
		
		for(Rectangle r:rects){
			r.setWidth(bandWidth);
			r.setHeight(2);
		}
		
		System.out.println("bandwidth is : " + bandWidth);
		
    }
}