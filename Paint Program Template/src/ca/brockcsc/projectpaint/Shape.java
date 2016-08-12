/*   
    Project Paint is a Java based paint program written for the 
    Brock CSC Project Series
 
    Copyright (C) 2016  Adam Balint

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package ca.brockcsc.projectpaint;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	
	// Shapes can be 2 types, either an outline or a solid shape
	public enum Type{
		solid, outline
	}
	
	// Storing width and height
	protected int x, y;
	protected int width, height;
	protected Type shapeType;
	
	// Base getters and setters
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
	// to draw the shape
	public abstract void drawShape(Graphics g);
	
	
}
