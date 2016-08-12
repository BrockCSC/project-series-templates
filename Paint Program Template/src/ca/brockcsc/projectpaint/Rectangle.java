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
