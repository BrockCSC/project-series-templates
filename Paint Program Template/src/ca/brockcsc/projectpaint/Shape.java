package ca.brockcsc.projectpaint;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	
	public enum Type{
		solid, outline
	}
	
	//storing width and height
	protected int x, y;
	protected int width, height;
	protected Type shapeType;
	
	//base getters and setters
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setPoint(Point p){
		x = (int)p.getX();
		y = (int)p.getY();
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Point getPoint(){
		return new Point (x,y);
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	// Abstract methods - each shape needs its own implementation
	public abstract void drawShape(Graphics g);
	
	
}
