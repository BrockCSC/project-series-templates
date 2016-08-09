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

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Drawable objects
 * @author brad
 * @version 1.0
 * @since Aug 5, 2016
 */
public interface Drawable {
	/**
	 * Any game logic the drawable needs to do
	 * @param delta
	 */
	public void update(long delta);
	
	/**
	 * Draw the element relative to the viewport
	 * @param graphics object that allows drawing
	 * @param viewport box that represents the current viewport
	 */
	public void draw(Graphics graphics, Rectangle viewport);
	
	/**
	 * Any movement based updating
	 * @param delta
	 */
	public void move(long delta);
}
