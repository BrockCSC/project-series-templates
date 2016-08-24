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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Implements a basic tile that only does collision
 * this class can be extended in order to make special tiles
 * as can be seen in BrickTile
 * @author brad
 * @version 1.0
 * @since Aug 5, 2016
 */
public class BasicTile implements Collidable {
	
	Rectangle location;
	Image img;
	
	/**
	 * @param p the top left point of the tile
	 * @param img specify the actual image
	 */
	BasicTile(Point p, BufferedImage img) {
		location = new Rectangle(p, new Dimension(img.getWidth(), img.getHeight()));
		this.img = img;
	}
	
	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Drawable#update(long)
	 */
	@Override
	public void update(long delta) {
		// Do nothing
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Drawable#draw(java.awt.Graphics, java.awt.Rectangle)
	 */
	@Override
	public void draw(Graphics graphics, Rectangle viewport) {
		// If the rectangles have ANY intersection, draw
		if (location.intersects(viewport))
			// We must subtract the viewpoint location, as it is the "box" over our world
			graphics.drawImage(img, (int) (location.x - viewport.getX()), (int)(location.y - viewport.getY()), null);

	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Collidable#getBoundingBox()
	 */
	@Override
	public Rectangle getBoundingBox() {
		// Copy old rectangle
		return new Rectangle(location);
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Collidable#actionCollision(ca.brockcsc.mariomashup.Entity)
	 */
	@Override
	public void actionCollision(Entity e) {
		Rectangle bb = e.getBoundingBox();
		Rectangle in = this.getBoundingBox().intersection(bb);
		
		if (in.getWidth() > in.getHeight() && in.getWidth() > 1 ) { // Up down collision
			if (bb.getCenterY() < location.getCenterY()) { // Falling
				e.setLocation(new Point(bb.x, (int) (location.getMinY()-bb.getHeight())));
				e.setAccY(0);
				e.setVelocityY(0);
				e.setLanded();
			} else {
				e.setLocation(new Point(bb.x, (int) location.getMaxY()));
				e.setAccY(0);
				e.setVelocityY(0);
			}
			// Left right collision additional requirements that there is a collision
			// of over 1 height
		} else if (in.getHeight() > 2 && Math.abs(e.getVelocityX()) > 1) {  
			if (bb.getCenterX() < location.getCenterX()) { // Left moving right
				e.setLocation(new Point((int) (location.getMinX() - bb.getWidth()), bb.y));
				e.setVelocityX(0);
			} else if (bb.getCenterX() > location.getCenterX()) {
				e.setLocation(new Point((int) location.getMaxX(), bb.y));
				e.setVelocityX(0);
			}
		}
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Drawable#move(long)
	 */
	@Override
	public void move(long delta) {
		// Nothing
	}

}
