package multiscreeninput;

import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Controller {
	
	@FXML
	private Slider rgbRed;
	@FXML
	private Slider rgbGreen;
	@FXML
	private Slider rgbBlue;
	
	@FXML
	 Button playButton;
	@FXML
	private Button songButton;
	@FXML
	private Button imageButton;
	
	@FXML
	private TextField selectSongText;
	
	@FXML
	private Label imageLabel;
	@FXML
	private Label ErrorLabel;
	
	@FXML
	private ComboBox<String> combobox;
	
	@FXML
	private ColorPicker colorVisualiser;
	@FXML
	private ColorPicker colorBackground;

	private String visualiserColour = "0xffffffff";
	
	private String visType;
	
	private String imageURI;
	private String fileURI;
		
	private MediaPlayer player;
    
    private static int bands;
   
    private List<VisualController> controllerList = new ArrayList<VisualController>();
    
    private double[] magArr;
    private double[] phaseArr;
    
    public boolean playing = false;
    
    

	@FXML
	private void initialize() {
	
		Font.loadFont(
	    	      Controller.class.getResource("Dense.otf").toExternalForm(), 
	    	      18
	    	    ); //Loads in font for use in GUI
		//action event for the play button
		playButton.setOnAction((event) -> {
			System.out.println("Play");
				
				initMediaPlayer();//call initMediaPlayer method
			//if statements to check visualiser type
			if(getVisType() == "Circle"){
				try {
					System.out.println("in da circle try");
					openCircleVisualiser(event); //Runs Circle Function
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(getVisType() == "Line"){
				try {
					System.out.println("int da bar try");
					openBarVisualiser(event); //Runs Bar Function
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(getVisType() == null){
				ErrorLabel.setText("Please Select a Visualiser Design"); 
				//Error message when Design not selected and play is clicked
			}
		});
		
		colorVisualiser.valueProperty().addListener((observable, oldValue, newValue) -> {
		    System.out.println("Visualiser:"+colorVisualiser.getValue());
		    visualiserColour=colorVisualiser.getValue().toString();
		    System.out.println("yo skrill" + getVisColour());
		    //Colour select and designation for Visualiser 
		});
		
		colorBackground.valueProperty().addListener((observable, oldValue, newValue) -> {
		    System.out.println("Background:"+colorBackground.getValue());
		    
		    //Colour select for Background
		});
		
		combobox.getItems().clear();
	
		combobox.getItems().addAll(
		            "Circle",
		            "Line",
		            "Box *DLC*" );//Design Combobox
		
		combobox.valueProperty().addListener((observable, oldValue, newValue) -> {
		    System.out.println(combobox.getValue());
		    visType= combobox.getValue();
		    System.out.println("ger away ouda dat" + getVisType());
		});
		
		
		BooleanBinding booleanBind =(selectSongText.textProperty().isEmpty());
		playButton.disableProperty().bind(booleanBind);//Disables button if Song not selected
		
		new AnimationTimer(){
	        public void handle(long currentNanoTime){
	            if(controllerList.size() != 0){
	            	for (VisualController v:controllerList){                    
	            		v.update();
	            	} //this is a handle to update the visualiser 
	            }
	        }
	    }.start();
	}

	public void openSongChooser(ActionEvent event) throws IOException {
		
		
		
    	FileChooser fileChooser = new FileChooser(); //Selecting the song from computer files
    	fileChooser.setTitle("View Music");
    	fileChooser.setInitialDirectory(getMusicDirectory());
    	//might add a filter to only accept certain file extentions 
    	//setFileExtensionFilter(fileChooser);
    	File file = fileChooser.showOpenDialog(imageButton.getScene().getWindow());
    	selectSongText.setText(file.toString());//takes selected file location and converts to string

    	System.out.println("the song yo selected be " + file);
    	fileURI = file.toURI().toString();//file to string URI convertion

    	
	}
	
	private File getMusicDirectory(){
    	
    	//Set to Music directory or go to default if cannot access
    	String userDirectoryString = System.getProperty("user.home");
    	File musicDirectory = new File(userDirectoryString+"/Music");
    	if(!musicDirectory.canRead()) {
    	    musicDirectory = new File(userDirectoryString);
    	}
    	return musicDirectory;
    }
	
	public void openImageChooser(ActionEvent event) throws IOException{
		FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Select Image");
    	fileChooser.setInitialDirectory(getPictureDirectory());
    	//might add a filter to only accept certain file extentions 
    	File file = fileChooser.showOpenDialog(songButton.getScene().getWindow());
    	imageLabel.setText(file.toString());
    	imageURI = file.toURI().toString();
    	System.out.println("the image is : " + imageURI);
	}
	
private File getPictureDirectory(){
    	
    	//Set to Music directory or go to default if cannot access
    	String userDirectoryString = System.getProperty("user.home");
    	File pictureDirectory = new File(userDirectoryString+"/Pictures");
    	if(!pictureDirectory.canRead()) {
    	    pictureDirectory = new File(userDirectoryString);
    	}
    	return pictureDirectory;
    }
	
	
	public void openCircleVisualiser(ActionEvent event) throws IOException {
	    //Circle Design Function
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Circle.fxml"));//loads in the fxml file
        VBox newWindow = (VBox)loader.load();//creates a vbox and adds the loader

        CircleController circleController = loader.getController();//instanciates the controller for the specific visualiser
        
        controllerList.add(circleController);//add instance to the arraylist
       
        circleController.setMainWindow(this);
        
        Stage stage = new Stage();
        
        stage.initOwner(playButton.getScene().getWindow());       
        //creates new window one play button click
        Scene scene = new Scene(newWindow);
       
        stage.setScene(scene);
        
        stage.show();  
        stage.setFullScreen(true);
        
        if(!playing){//if the song is not playing begin playing the song
        	player.play();
        	playing = true;
        }
    }

	public void openBarVisualiser(ActionEvent event) throws IOException {
		//Bar design function
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("Bars.fxml"));
	    VBox newWindow = (VBox)loader.load();
	
	    BarController barController = loader.getController();
	    
	    controllerList.add(barController);
	   
	    barController.setMainWindow(this);
	
	    Stage stage = new Stage();
	    
	    stage.initOwner(playButton.getScene().getWindow());       
	    
	    Scene scene = new Scene(newWindow);
	   
	    stage.setScene(scene);
	    //Creates new window on play button click for bars
	    stage.show();   
	    stage.setFullScreen(true);
	    if(!playing){
        	player.play();
        	playing = true;
        }
	}

	private void initMediaPlayer(/*String filePath*/){
    	
    	Media media = new Media(fileURI);
    	
    	player = new MediaPlayer(media);//creates a new media player with the file URI media
    	
	    bands = player.getAudioSpectrumNumBands();//gets the amount of bands
	    System.out.println("there are " + getBands() + " bands");
	    magArr = new double[bands];
	    phaseArr = new double[bands];
	    
	    //how many times a second the spectrum updates
	    player.setAudioSpectrumInterval(0.016);
	    
	    player.setAudioSpectrumListener(new AudioSpectrumListener() {//analyses the audio
            @Override
            public void spectrumDataUpdate(double v, double v1, float[] mags, float[] phase) {
            	for( int i=0; i<bands; i++){
            		double magnitude = mags[i]+60;//sets the magnitude plus 60, as it goes fom -60 to 0
            		//double magnitude2 = floats1[i]; //magnitude of phases
            		phaseArr[i] = phase[i];
            		if(magnitude>0.1){//adds the magnitude to the array
            			magArr[i] = magnitude;
            		}
            		if(magnitude<0.1){
            			magArr[i] = 0.1;
            		}
            	}
            }            
	    });
    }

	public String getVisColour(){
		return visualiserColour;
	}
	
	public String getVisType(){
		return visType;
	}
	
/*	public String getSongFile(){
		return fileURI;
	}*/

	public double[] getMags(){
		return magArr;
	}
	
	public double[] getPhase(){
		return phaseArr;
	}
	
	public int getBands(){
		return bands;
	}

	
}

