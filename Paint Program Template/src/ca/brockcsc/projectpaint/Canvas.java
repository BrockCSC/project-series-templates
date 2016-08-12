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
