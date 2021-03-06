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

import java.awt.Rectangle;

/**
 * Collidable objects
 * @author brad
 * @version 1.0
 * @since Aug 5, 2016
 */
public interface Collidable extends Drawable {
	
	/**
	 * Get the bounding box as a rectangle where the Collidable 
	 * object is currently
	 * @return
	 */
	public Rectangle getBoundingBox();
	/**
	 * What you do with the entity you collide with
	 * @param e
	 */
	public void actionCollision(Entity e);
}
