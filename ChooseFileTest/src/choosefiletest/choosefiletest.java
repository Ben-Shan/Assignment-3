package choosefiletest;

public class choosefiletest {
	
    choosefiletest chooser = new choosefiletest();
    FileNameExtensionFilter filter = new FileNameExtensionFilter
    		( "JPG & GIF Images", "jpg", "gif");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(parent);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getName());
    }

}
