package javaFXsound;

public class Visuals extends SoundPlayer{

	public static void main(String[] args) {

	}

	public int bands;
	
	public void visuals(int bands){
		
		Bars bars = new Bars(bands);
		bars.print();
	}
	
}
