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
import java.util.ArrayList;

import javax.swing.*;

/*
 * Holds and manages the canvas that will be drawn to
 */


public class Canvas extends JPanel{

	// Holds all the shapes already on the canvas, and the new shape that will be added
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape newShape = null;
	
	// Holds if the user is in the process of drawing
	private boolean drawing = false;
	
	
	// Set up the canvas
	public Canvas(){
	}
	
	// Draw graphics onto the canvas
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// Draw all the shapes to the canvas
		for (Shape s : shapes){
			s.drawShape(g);
		}
		// If the user is drawing then show the shape they are currently adding
		if (drawing)
			newShape.drawShape(g);
		
	}
	
	// Updates if the user is drawing, and their current shape
	public void drawing (boolean drawing, Shape tmpShape){
		this.drawing = drawing;
		newShape = tmpShape;
	}
	
	// Adds the shape to the canvas
	public void addShape(Shape s){
		shapes.add(s);
	}
	
	
	
}
