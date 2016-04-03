package multiscreeninput;

public abstract class VisualController {
	
    protected MainWindowController mainWindow;

    public void setMainWindow(MainWindowController mainWin){
        mainWindow = mainWin;
    }
    
    public abstract void update();
    	
}
