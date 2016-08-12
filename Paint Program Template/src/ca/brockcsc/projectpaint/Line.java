package ca.brockcsc.projectpaint;

import java.awt.Graphics;

public class Line extends Shape{

	public Line(){
		this(-1,-1,0,0);
	}
	
	public Line (int x, int y){
		this (x,y,0,0);
	}
	
	public Line (int x, int y, int width, int height){
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.height = height;
		this.shapeType = Shape.Type.outline;
	}

	
	
	@Override
	public void drawShape(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(x, y, x+width, y+height);
	}

}
