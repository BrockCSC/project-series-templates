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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/*
 * Holds all the listeners for the mouse and buttons for both frames
 */


public class Listeners implements MouseListener, MouseMotionListener, ActionListener{

	
	// Local variables, points to canvas and menu frames
	private boolean mousePressed = false; // Tracks if user released mouse button
	private JFrame fCanv, fMenu;
	private Canvas c;
	
	// Holds current shape they are drawing, and the last shape that was selected from the menu
	private Shape tmpShape = new Line();
	private String currentShape = "line";
	
	
/*	public void setTmpShape (Shape s){
		tmpShape = s;
	}*/
	
	// Constructor that passes in references to the frames and canvas
	public Listeners (JFrame fCanv, JFrame fMenu, Canvas c){
		this.fCanv = fCanv;
		this.fMenu = fMenu;
		this.c = c;
	}
	
	
	// Mouse dragged event handler
	// When mouse dragged, update the width of the width and height of the shape and repaint canvas
	@Override
	public void mouseDragged(MouseEvent e) {
		tmpShape.setHeight((int)(e.getY() - tmpShape.getY()));
		tmpShape.setWidth((int)(e.getX() - tmpShape.getX()));
		c.drawing(true, tmpShape);
		c.repaint();
		
	}

	// Mouse moved event handler
	// When mouse is moved repaint the canvas
	@Override
	public void mouseMoved(MouseEvent e) {
		c.repaint();
	}

	// Mouse clocked event handler
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	// Mouse pressed event handler
	// When mouse pressed, create a new shape and set location and draw
	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
		createNewShape();
		tmpShape.setPoint(e.getPoint());
		c.repaint();
	}

	// Mouse released event handler
	// When mouse is released, swap flags and add shape to canvas
	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
		c.addShape(tmpShape);
		c.drawing(false, tmpShape);
		c.repaint();
	}

	// Mouse entered frame event handler
	@Override
	public void mouseEntered(MouseEvent e) {
		c.repaint();
	}

	// Mouse dragged exited handler
	@Override
	public void mouseExited(MouseEvent e) {
		c.repaint();
	}

	// Button pressed event handler
	// Sets which menu item was last selected
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "menu_Rectangle Tool":
			currentShape = "rect";
			break;
		case "menu_Filled Rectangle Tool":
			currentShape = "fill_rect";
			break;
		case "menu_Line Tool":
			currentShape = "line";
			break;
		}
	}

	// Sets the current working shape to a new shape based on last
	// menu item selected
	private void createNewShape(){
		switch (currentShape){
		case "line":
			tmpShape = new Line();
			break;
		case "rect":
			tmpShape = new Rectangle(Shape.Type.outline);
			break;
		case "fill_rect":
			tmpShape = new Rectangle(Shape.Type.solid);
			break;
		}
	}
	
}
