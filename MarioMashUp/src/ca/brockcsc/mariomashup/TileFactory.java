/*
 *  This file is part of ca.brockcsc.mariomashup, a platformer game
 *  parody of Super Mario Bros. 
 *  Copyright (C) 2016  Bradley A Kennedy
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package ca.brockcsc.mariomashup;

import java.awt.Point;

/**
 * Builds tile objects based on the 
 * requested location in the tilemaps
 * This class follows the Factory pattern. Whereas it is a class
 * that generates objects of a super class. Additionally it could be
 * implement an interface which would allow you to change the Factory object
 * for another class
 * @author brad
 * @version 1.0
 * @since Aug 6, 2016
 */
public class TileFactory {
	TileFactory() {
		
	}
	
	private final static int WIDTH = 29;
	@SuppressWarnings("unused")
	private final static int HEIGHT = 28;
	
	BasicTile generateTile(int i, Point p) {
		int row = i / WIDTH;
		int col = i % WIDTH;
		return new BasicTile(p, GraphicManagerSingleton.getInstance().retrieveImage(String.format("tiles-2-%d-%d", row, col)));
	}
	
	BasicTile generateSpecialTile(int i, Point p) {
		switch(i){
		case 1:
			return new BrickTile(p);
		case 2:
			return new KillTile(p);
		default:
			return null;
		}
	}
}
