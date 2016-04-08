package multiscreeninput;

/**
 *  'VisualDisplay.fxml' Controller Class
 */


import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.animation.FillTransition; 
import javafx.event.ActionEvent;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle; 
import javafx.animation.Timeline; 
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition; 
import javafx.animation.RotateTransition; 
import javafx.animation.ScaleTransition; 
import javafx.animation.TranslateTransition; 
import javafx.util.Duration; 


public class VisualDisplayController {

    @FXML // fx:id="closeBtn"
    private Button closeBtn; // Value injected by FXMLLoader

    @FXML // fx:id="topPane
    private Pane topPane;
    
    @FXML // fx:id="canvas"
    private Canvas canvas; // Value injected by FXMLLoader
    
    
    public void closeWindow(ActionEvent event){
        ((Button)event.getSource()).getScene().getWindow().hide();
    }

    
    
    public void drawOnPane(int height ){
    	Rectangle rect = new Rectangle(0, 0, 250, height); 
    	rect.setFill(Color.BLUE); 
    	topPane.getChildren().add(rect); 
    
    }
    
    /***

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	drawOnPane(200);
    
    }
    
    
    public void update(int height){
    	
    		drawOnPane(height);
    }
    
    
        GraphicsContext gc = canvas.getGraphicsContext2D();
    	gc.strokeOval(60, 60, 30, 30);
    	canvas.getScene().getRoot().getCh
    	.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    	
    	Rectangle rect = new Rectangle(0, 0, 250, 250); 
    	rect.setFill(Color.BLUE); 
        canvas.getChildren().add(rect); 
        //GraphicsContext gc = canvas.getGraphicsContext2D();
 
        TranslateTransition translate = 
        new TranslateTransition(Duration.millis(750)); 
        translate.setToX(390); 
        translate.setToY(390); 
 
        FillTransition fill = new FillTransition(Duration.millis(750)); 
        fill.setToValue(Color.RED); 
 
        RotateTransition rotate = new RotateTransition(Duration.millis(750)); 
        rotate.setToAngle(360); 
 
        ScaleTransition scale = new ScaleTransition(Duration.millis(750)); 
        scale.setToX(0.1); 
        scale.setToY(0.1); 
 
        ParallelTransition transition = new ParallelTransition(rect, translate, fill, rotate, scale); 
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true); 
        transition.play(); 
    	
    }
    
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	Rectangle rect = new Rectangle(0, 0, 250, 250); 
    	rect.setFill(Color.BLUE); 
        canvas.getChildren().add(rect); 
        //GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        
        
        final long timeStart = System.currentTimeMillis();
        
        	KeyFrame kf = new KeyFrame(
            Duration.seconds(0.017),                // 60 FPS
            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent ae)
                {
                    double t = (System.currentTimeMillis() - timeStart) / 1000.0; 
        
                }
            
                    
               });
            
                    
        TranslateTransition translate = 
        new TranslateTransition(Duration.millis(750)); 
        translate.setToX(390); 
        translate.setToY(390); 
 
        FillTransition fill = new FillTransition(Duration.millis(750)); 
        fill.setToValue(Color.RED); 
 
        RotateTransition rotate = new RotateTransition(Duration.millis(750)); 
        rotate.setToAngle(360); 
 
        ScaleTransition scale = new ScaleTransition(Duration.millis(750)); 
        scale.setToX(0.1); 
        scale.setToY(0.1); 
 
        ParallelTransition transition = new ParallelTransition(rect, translate, fill, rotate, scale); 
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true); 
        transition.play(); 
    }
    
    ***/
    
    
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	Rectangle rect = new Rectangle(0, 0, 250, 250); 
    	rect.setFill(Color.BLUE); 
        topPane.getChildren().add(rect); 
 
        TranslateTransition translate = 
        new TranslateTransition(Duration.millis(750)); 
        translate.setToX(390); 
        translate.setToY(390); 
 
        FillTransition fill = new FillTransition(Duration.millis(750)); 
        fill.setToValue(Color.RED); 
 
        RotateTransition rotate = new RotateTransition(Duration.millis(750)); 
        rotate.setToAngle(360); 
 
        ScaleTransition scale = new ScaleTransition(Duration.millis(750)); 
        scale.setToX(0.1); 
        scale.setToY(0.1); 
 
        ParallelTransition transition = new ParallelTransition(rect, translate, fill, rotate, scale); 
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true); 
        transition.play(); 
    	
    }
    
    
}