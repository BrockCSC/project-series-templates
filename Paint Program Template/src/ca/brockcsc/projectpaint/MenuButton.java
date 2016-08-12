package ca.brockcsc.projectpaint;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuButton extends JButton{

	public MenuButton(){
		
	}
	
	public MenuButton (String imageName, String desc, Listeners l){
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(new File ("MenuIcons/"+imageName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setIcon(icon);
		this.setToolTipText(desc);
		
		this.setBackground(Color.gray);
		
		this.setActionCommand("menu_"+desc);
		this.addActionListener(l);
	}
	
}
