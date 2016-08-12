package ca.brockcsc.projectpaint;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Stores the custom configuration for the side-menu buttons
 */

public class MenuButton extends JButton{

	// empty menu button does nothing
	public MenuButton(){
	}
	
	// Menu button constructor given name, description and which listeners will wait for button click
	public MenuButton (String imageName, String desc, Listeners l){
		
		// Load the button image
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(new File ("MenuIcons/"+imageName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Set the button image and hovering tool tip
		this.setIcon(icon);
		this.setToolTipText(desc);
		
		// Set the button background color to white
		this.setBackground(Color.white);
		
		// Create action command for button to be able to distinguish from other buttons
		this.setActionCommand("menu_"+desc);
		// Register button with the listener
		this.addActionListener(l);
	}
	
}
