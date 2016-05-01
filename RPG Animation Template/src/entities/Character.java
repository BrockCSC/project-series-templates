package entities;

import game.Main;
import utilities.Animation;

public class Character {
	private int xLoc, yLoc;
	private int width, height;
	private Animation animate;
	
	public Character(){
		animate = new Animation ();
		width = animate.getWidth();
		height = animate.getHeight();
		xLoc = (Main.SCREEN_WIDTH/2) - (width/2);
		yLoc = (Main.SCREEN_HEIGHT/2) - (height/2);
	}
	
	
}
