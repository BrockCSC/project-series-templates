package ca.brockcsc.projectpaint;

import java.awt.Graphics;

/*
 * Holds the information required to draw a line 
 */


public class Line extends Shape{

	// Default line drawn off screen
	public Line(){
		this(-1,-1,0,0);
	}
	
	// Line constructor with specified x and y coordinates
	public Line (int x, int y){
		this (x,y,0,0);
	}
	
	// Line constructor with specified x, y coordinates as well as width and height
	public Line (int x, int y, int width, int height){
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.height = height;
		this.shapeType = Shape.Type.outline;
	}

	
	
	// Draws the line
	@Override
	public void drawShape(Graphics g) {
		g.drawLine(x, y, x+width, y+height);
	}

}
