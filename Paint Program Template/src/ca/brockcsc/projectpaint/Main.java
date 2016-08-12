package ca.brockcsc.projectpaint;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


/* 
 * Sets up the frames for the paint program
 */

public class Main {

	static Shape tmpShape = new Rectangle();
	
	public Main(){
		// Get the icon for the frame
		Image frameIcon = null;
		try {
			 frameIcon = ImageIO.read(new File ("MenuIcons/frame_icon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Create and set up a new frame
		JFrame f = new JFrame("Project Paint");
		f.setIconImage(frameIcon);
		f.getContentPane().setPreferredSize(new Dimension(500,500));
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		//Create a new canvas to draw on
		Canvas c = new Canvas();
		
		// Create the frame to show the tools
		JFrame menuFrame = new JFrame();
		menuFrame.setIconImage(frameIcon);
		menuFrame.setResizable(false);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create an instance that handles all of the action events
		// Mouse movement, mouse clicks, button presses
		Listeners l = new Listeners(f, menuFrame, c);
		
		// Track mouse movement and clicks on the canvas frame
		f.getContentPane().addMouseListener(l);
		f.getContentPane().addMouseMotionListener(l);
				
		f.add(c);
		
		// Set up menu frame to display icons in a 2x2 grid and add the buttons to it
		menuFrame.setLayout(new GridLayout(2,2));
		menuFrame.add(new MenuButton("line.png", "Line Tool", l));
		menuFrame.add(new MenuButton("rectangle.png", "Rectangle Tool", l));
		menuFrame.add(new MenuButton("filled_rectangle.png", "Filled Rectangle Tool", l));
		menuFrame.pack();
		
		// set the canvas frame and menu frame visible
		f.setVisible(true);
		menuFrame.setVisible(true);
	}
	
	// Entry Point
	public static void main(String[] args) {
		new Main();
	}

}
