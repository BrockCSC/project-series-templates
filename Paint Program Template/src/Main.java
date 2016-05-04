import java.awt.Dimension;

import javax.swing.*;


public class Main {

	public Main(){
		// Create and set up a new frame
		JFrame f = new JFrame("Project Paint");
		f.getContentPane().setPreferredSize(new Dimension(500,500));
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		//Create a new canvas to draw on
		Canvas c = new Canvas();
		f.add(c);
		
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
