package ca.brockcsc.projectpaint;

import java.awt.Graphics;

public class Rectangle extends Shape{

	public Rectangle(){
		this(-1,-1,0,0);
	}
	
	public Rectangle(Type rectType){
		this(-1,-1,0,0, rectType);
	}
	
	public Rectangle (int x, int y){
		this (x,y,0,0);
	}
	
	public Rectangle (int x, int y, int width, int height){
		this (x, y, width, height, Type.outline);
	}
	public Rectangle (int x, int y, int width, int height, Type shapeType){
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.height = height;
		this.shapeType = shapeType;
	}
	
	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		if (shapeType == Shape.Type.solid)
			g.fillRect(x, y, width, height);
		else if (shapeType == Shape.Type.outline)
			g.drawRect(x, y, width, height);
	}

}
