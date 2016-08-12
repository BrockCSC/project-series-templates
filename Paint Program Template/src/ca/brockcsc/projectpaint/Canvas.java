package ca.brockcsc.projectpaint;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

public class Canvas extends JPanel{

	ArrayList<Shape> shapes = new ArrayList<Shape>();
	Shape newShape = null;
	
	
	private boolean drawing = false;
	//set up the canvas
	public Canvas(){
	}
	
	//draw graphics onto the canvas
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.fillRect(10, 10, 10, 10); //draw a black square
		for (Shape s : shapes){
			s.drawShape(g);
		}
		if (drawing)
			newShape.drawShape(g);
		
	}
	
	public void drawing (boolean drawing, Shape tmpShape){
		this.drawing = drawing;
		newShape = tmpShape;
	}
	
	public void addShape(Shape s){
		shapes.add(s);
	}
	
	
	
}
