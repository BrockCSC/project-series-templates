package game;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel{
	
	public Display(){
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		g.fillRect(10, 10, 10, 10);	
	}
	
	
	
	
}
