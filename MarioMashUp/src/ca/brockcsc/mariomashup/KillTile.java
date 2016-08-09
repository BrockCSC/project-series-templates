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
 * Example Special tile that does damage to the hero
 * if they touch
 * @author brad
 * @version 1.0
 * @since Aug 6, 2016
 */
public class KillTile extends BasicTile {

	KillTile(Point p) {
		super(p, GraphicManagerSingleton.getInstance().retrieveImage("tiles-2-0-16"));
	}
	
	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Collidable#actionCollision(ca.brockcsc.mariomashup.Entity)
	 */
	@Override
	public void actionCollision(Entity e) {
		//Rectangle bb = e.getBoundingBox();
		//Rectangle in = this.getBoundingBox().intersection(bb);
		
		if (e instanceof Hero) {
			Hero h = (Hero) e;
			h.doDamage();
		}
	}
	
}
