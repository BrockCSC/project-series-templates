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
