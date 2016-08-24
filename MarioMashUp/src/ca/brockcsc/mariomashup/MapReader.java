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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Map reading helper functions
 * @author brad
 * @version 1.0
 * @since Aug 6, 2016
 */
public class MapReader {

	/** 
	 * Programmer note: Static functions do not require an object to be executed
	 * so this class never has to be initialized
	 * 
	 * Read a map into the provided ArrayList structures
	 * @param f File that has an ascii text file wit h the map structure
	 * @param into the tile ArrayList structures with a few layers, the first 
	 * Arraylist respresents the layer.
	 * @param entities the entities to place on the map no layers
	 * @return the floor on the map, should be +tve integer
	 */
	static int readMap(File f, ArrayList<ArrayList<Drawable>> into, ArrayList<Entity> entities) {
		int maxY = Integer.MAX_VALUE;
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		int rows = 0;
		int cols = 0;
		try {
			rows = s.nextInt();
			cols = s.nextInt();
		} catch (Exception e) {
			throw new RuntimeException("Error occured while scanning for rows and cols", e);
		}
		TileFactory tf = new TileFactory();
		BasicTile tile;
		String st;
		try {
			for (int row = 0; row < rows; ++row) {
				for (int col = 0; col < cols; ++col) {
					st = s.next();
					char tiletype = st.charAt(0);
					switch (tiletype) {
					case 'h': // Hero
						Hero h = new Hero(new Point(col * 16, row * 16), "characters-0", "characters-1");
						into.get(Integer.valueOf("" + st.charAt(1))).add(h);
						entities.add(h);
						break;
					case 't':
						tile = tf.generateTile(Integer.valueOf(st.substring(2)), new Point(col * 16, row * 16));
						if (tile != null) {
							into.get(Integer.valueOf("" + st.charAt(1))).add(tile);
						}
						break;
					case 's':
						tile = tf.generateSpecialTile(Integer.valueOf(st.substring(2)), new Point(col * 16, row * 16));
						if (tile != null) {
							into.get(Integer.valueOf("" + st.charAt(1))).add(tile);
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Error occured when reading characters from map", e);
		}
		maxY = rows * 16 + 16;
		return maxY;
	}
}
