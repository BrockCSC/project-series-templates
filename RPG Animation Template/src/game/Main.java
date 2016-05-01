package game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	public static final int SCREEN_WIDTH = 500, SCREEN_HEIGHT = 500;
	
	// We set up the frame that will contain the game in the constructor
	public Main(){
		// Creates a new frame and sets the title
		JFrame f = new JFrame("RPG Animation Template");
		// Sets the size of the area contained by the frame
		f.getContentPane().setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		// Sets the frame size to be static
		f.setResizable(false); 
		// Sets what the frame should do when the 'X' button is pressed
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Resizes the frame to contain all of the elements
		//	- In this case just to make the frame 500 x 500
		f.pack();
		// Sets the location of the frame to be the center of the screen
		f.setLocationRelativeTo(null);
		// Sets the frame to be visible
		f.setVisible(true);
		
		// Adds the display that will display the game to the frame
		f.add(new Display());
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
