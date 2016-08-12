package ca.brockcsc.projectpaint;

import java.awt.Graphics;
/*
 * Holds the information required to draw a rectangle  
 */
public class Rectangle extends Shape{

	// Rectangle constructor off screen
	public Rectangle(){
		this(-1,-1,0,0);
	}
	
	// Constructor setting solid or outline type of rectangle
	public Rectangle(Type rectType){
		this(-1,-1,0,0, rectType);
	}
	
	// Constructor giving x and y coordinates
	public Rectangle (int x, int y){
		this (x,y,0,0);
	}
	
	// Constructor specifying x, y, width and height 
	public Rectangle (int x, int y, int width, int height){
		this (x, y, width, height, Type.outline);
	}
	
	// Rectangle constructor specifying x,y,width, height and solid or outline type
	public Rectangle (int x, int y, int width, int height, Type shapeType){
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.height = height;
		this.shapeType = shapeType;
	}
	
	
	// Draws the rectangle as a solid or outline rectangle
	@Override
	public void drawShape(Graphics g) {
		if (shapeType == Shape.Type.solid)
			g.fillRect(x, y, width, height);
		else if (shapeType == Shape.Type.outline)
			g.drawRect(x, y, width, height);
	}

}
