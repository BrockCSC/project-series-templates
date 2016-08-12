package ca.brockcsc.projectpaint;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Main {

	static Shape tmpShape = new Rectangle();
	
	public Main(){
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
		
		
		JFrame menuFrame = new JFrame();
		menuFrame.setIconImage(frameIcon);
		menuFrame.setResizable(false);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Listeners l = new Listeners(f, menuFrame, c);
		
		f.getContentPane().addMouseListener(l);
		f.getContentPane().addMouseMotionListener(l);
				
		f.add(c);
		
		menuFrame.setLayout(new GridLayout(2,2));
		menuFrame.add(new MenuButton("line.png", "Line Tool", l));
		menuFrame.add(new MenuButton("rectangle.png", "Rectangle Tool", l));
		menuFrame.add(new MenuButton("filled_rectangle.png", "Filled Rectangle Tool", l));
		menuFrame.pack();
		
		
		
		
		
		
		f.setVisible(true);
		menuFrame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}