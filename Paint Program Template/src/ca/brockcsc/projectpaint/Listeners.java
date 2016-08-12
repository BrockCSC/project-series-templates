package ca.brockcsc.projectpaint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Listeners implements MouseListener, MouseMotionListener, ActionListener{

	boolean mousePressed = false;
	private JFrame fCanv, fMenu;
	private Canvas c;
	private Shape tmpShape = new Line();
	private String currentShape = "line";
	
	public void setTmpShape (Shape s){
		tmpShape = s;
	}
	
	public Listeners (JFrame fCanv, JFrame fMenu, Canvas c){
		this.fCanv = fCanv;
		this.fMenu = fMenu;
		this.c = c;
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		tmpShape.setHeight((int)(e.getY() - tmpShape.getY()));
		tmpShape.setWidth((int)(e.getX() - tmpShape.getX()));
		c.drawing(true, tmpShape);
		c.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		c.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = true;
		createNewShape();
		tmpShape.setPoint(e.getPoint());
		c.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = false;
		c.addShape(tmpShape);
		c.drawing(false, tmpShape);
		c.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		c.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		c.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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