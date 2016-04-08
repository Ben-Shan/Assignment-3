package multiscreeninput;

public abstract class VisualController {
	
    protected Controller mainWindow;

    public void setMainWindow(Controller mainWin){
        mainWindow = mainWin;
    }
    
    public abstract void update();
    	
}
