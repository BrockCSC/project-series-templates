import java.awt.Graphics;

import javax.swing.*;

public class Canvas extends JPanel{

	//set up the canvas
	public Canvas(){
		
		
	}
	
	//draw graphics onto the canvas
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(10, 10, 10, 10); //draw a black square
	}
	
	
}
