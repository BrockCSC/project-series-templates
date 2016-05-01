package utilities;

import java.awt.image.BufferedImage;

public class Animation {
	public enum Direction{
		UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT
	}
	
	private int numDirections;
	private BufferedImage[] animations;
	
	
	public Animation(){
		
	}
	public Animation(int directions) throws Exception{
		numDirections = directions;
		if (directions == 4 || directions == 8){
			animations = new BufferedImage[directions];
		}else{
			throw new Exception(){
				public String toString(){
					return "Invalid number of directions enetered";
				}
			};
		}
	}
	
	
	
	public int getWidth(){
		return -1;
	}
	public int getHeight(){
		return -1;
	}
	
}
