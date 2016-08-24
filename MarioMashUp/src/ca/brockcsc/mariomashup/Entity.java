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
 * Any object that interacts with the world more than
 * a block
 * @author brad
 * @version 1.0
 * @since Aug 5, 2016
 */
public interface Entity extends Collidable {
	
	/**
	 * @return the downward velocity, falling is +tve.
	 */
	double getVelocityY();	
	/**
	 * @return the horizontal velocity, right is +tve.
	 */
	double getVelocityX();
	/**
	 * @param x instantaneously set the horizontal velocity of the
	 * Entity to this value. Right is +tve.
	 */
	void setVelocityX(double x);
	/**
	 * @param y instantaneously set the vertical velocity of the 
	 * Entity to this value. Down is +tve.
	 */
	void setVelocityY(double y);
	/**
	 * @param x instantaneously set the horizontal acceleration of the 
	 * Entity to this value. Right is +tve
	 */
	void setAccX(double x);
	/**
	 * @param y instantaneously set the verticle acceleration of the
	 * Entity to this value. Down is +tve
	 */
	void setAccY(double y);
	
	/**
	 * @param p instantaneously set the location origin to this point.
	 * Corresponds to the top left corner of the sprite.
	 */
	void setLocation(Point p);
	/**
	 * Set the boolean flag to say the Entity has landed
	 */
	void setLanded();
	
}
