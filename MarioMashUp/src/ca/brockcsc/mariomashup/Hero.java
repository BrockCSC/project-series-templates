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
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import ca.brockcsc.mariomashup.KeyManager.Keys;

/**
 * Mario based actor entity
 * @author brad
 * @version 1.0
 * @since Aug 6, 2016
 */
public class Hero implements Entity {
	private static final String DEATH_FRAME_IMAGE = "characters-6-l";
	private static final double SPRINT_ACCEL = 120.0;
	private static final int WALK_MAX_SPEED = 64;
	private static final int RUN_MAX_SPEED = 128;
	private static final double JUMP_ACCELERATION = 240.0;
	private static final double FALL_ACCELERATION = 720.0;
	private static final double FLOAT_ACCELERATION = 360.0;
	private static final int DRAG_MULTIPLIER = 3;
	private static final double SLIDE_ACCEL = 256.0;
	
	private double locx, locy;
	private String spriteprefix;
	private String spriteprefixSmall;
	
	// Loops for running
	private int timeAnimation = 0;
	private int timeFrameMultiplier = 4;
	private int frame = 0;
	private int numframes = 3;
	
	// Other animations
	private static final int NUMIFRAMES = 2000;
	private static final int IFRAMES_SWITCH = 300;
	private static final int NUMSHRINKING = 300;
	private boolean isDieing = false;
	private boolean isShrinking = false;
	private boolean hasIFrames = true;
	private int iframes = 0;
	private int timeShrinkingAnimation = 0;
	
	// Animation speeds
	private int[] speedmulti = {512, 312, 256, 128}; 
	
	// Pixels per second
	private double velx = 16;
	private double vely = 0;
	private boolean landed = false;
	
	private double accx = 0;
	private double accy = 0;
	
	private boolean holdingright = false;
	private boolean holdingleft = false;
	private boolean holdingrun = false;
	
	private boolean facingright = true;
	
	// If the actor is taller
	private boolean big = true;
	// 
	private boolean crouching = false; 
	
	Hero(Point p, String spriteprefix, String spriteprefixSmall) {
		p.y -= 16;
		locx = p.getX();
		locy = p.getY();
		this.spriteprefix = spriteprefix;
		this.spriteprefixSmall = spriteprefixSmall;
	}
	
	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Collidable#getBoundingBox()
	 */
	@Override
	public Rectangle getBoundingBox() {
		if (isDieing) {
			return new Rectangle((int)locx, -1, 1, 1);
		}
		boolean full = big && !crouching;
		return new Rectangle((int)locx, (int)locy, 16, full ? 32 : 16);
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Collidable#actionCollision(ca.brockcsc.mariomashup.Entity)
	 */
	@Override
	public void actionCollision(Entity e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Drawable#update(long)
	 */
	@Override
	public void update(long delta) {
		if (isDieing) {
			return;
		}
		
		KeyManager km = KeyManager.getInstance();
		
		if (!km.getKey(Keys.DOWN) && crouching) {
			crouching = false;
			locy -= 16;
		}
		
		if (!crouching && km.getKey(Keys.DOWN) && big) {
			crouching = true;
			locy += 16;
		} 
		
		holdingright = km.getKey(Keys.RIGHT) && !crouching;
		holdingleft = km.getKey(Keys.LEFT) && !crouching;
		holdingrun = km.getKey(Keys.B);
		
		if (holdingright || holdingleft) {

			if (holdingright) {
				// Sliding accel and sprinting accel
				accx = velx < 0 ? SLIDE_ACCEL : SPRINT_ACCEL;
			} else if (holdingleft) {
				// Sliding accel and sprint accel
				accx = velx > 0 ? -SLIDE_ACCEL : -SPRINT_ACCEL;
			} 
			
			// Change the direction were facing if were accelerating in the opposite direction
			if (accx > 0 && !facingright) { // Sliding
				facingright = !facingright; 
			} else if (accx < 0 && facingright) { // Sliding
				facingright = !facingright;
			}
			// If not holding left or right
		} else {
			// Acceleration in the opposite direction of velocity as drag
			accx = -velx * DRAG_MULTIPLIER;
			// Stop if were moving slowly
			if (Math.abs(velx) < 1) {
				velx = 0;
			}
		}
		
		if (landed && vely > 1.5) {// We dropped
			landed = false;
		}

		// Jumping
		if (landed && km.getKey(Keys.A)) {
			landed = false;
			vely = -JUMP_ACCELERATION;
			accy = 0;
		// Floating
		} else if (km.getKey(Keys.A) && vely < 0) {
			accy = FLOAT_ACCELERATION;
		// Falling
		} else {
			accy = FALL_ACCELERATION;
		}
		
		// Animation and timers
		if (isShrinking) {
			timeShrinkingAnimation += delta;
		}
		if (timeShrinkingAnimation > NUMSHRINKING) {
			timeShrinkingAnimation = 0;
			isShrinking = false;
		}
		if (hasIFrames) {
			iframes += delta;
		}
		if (iframes > NUMIFRAMES) {
			iframes = 0;
			hasIFrames = false;
		}
		
		timeAnimation += timeFrameMultiplier * delta;	
	}
	
	@Override
	public void move(long delta) {
		velx += accx * (delta / 1000.0);
		vely += accy * (delta / 1000.0);
		
		velx = Math.min(holdingrun ? RUN_MAX_SPEED : WALK_MAX_SPEED, velx);
		velx = Math.max(holdingrun ? -RUN_MAX_SPEED: -WALK_MAX_SPEED, velx);
		
		locx += velx * (delta / 1000.0);
		locy += vely * (delta / 1000.0);
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Drawable#draw(java.awt.Graphics, java.awt.Rectangle)
	 */
	@Override
	public void draw(Graphics graphics, Rectangle viewport) {
		int tpf = (int) Math.min(Math.abs(velx) / 32, speedmulti.length - 1); 
		if (timeAnimation > speedmulti[tpf]) {
			timeAnimation = 0;
			frame++;
			frame %= numframes;
		}
		int framen = frame + 2;
		// Get walk animation frame
		if(Math.abs(velx) < 8) {
			framen = 0;
		}
		// Slide animations
		if ((holdingleft || holdingright) && velx > 0 ^ accx > 0) {
			framen = 5;
		}
		// Jumping animation
		if (vely < 0) {
			framen = 6;
		}
		// Crouch
		if (crouching) {
			framen = 1;
		} 
		if (isShrinking) {
			framen = 1;
		}
		if (isDieing) {
			BufferedImage bf = GraphicManagerSingleton.getInstance().retrieveImageFrame(DEATH_FRAME_IMAGE, 7);
			graphics.drawImage(bf, (int)locx - viewport.x, (int)locy - viewport.y - (crouching ? 16 : 0), null);
		} else {
			BufferedImage bf = GraphicManagerSingleton.getInstance().retrieveImageFrame(
					String.format("%s-%s", big ? spriteprefix : spriteprefixSmall, facingright ? "r": "l"), framen);
			if (getBoundingBox().intersects(viewport) && (!hasIFrames || iframes % IFRAMES_SWITCH > IFRAMES_SWITCH / 2 ))
				graphics.drawImage(bf, (int)locx - viewport.x, (int)locy - viewport.y - (crouching ? 16 : 0), null);
		}
		
		

		
	}

	/**
	 * Kill the hero actor, play animation
	 */
	public void kill() {
		isDieing = true;
		accx = 0;
		accy = FALL_ACCELERATION;
		velx = 0;
		vely = -JUMP_ACCELERATION*1.5;
	}
	
	/**
	 * If big, make small
	 * if small, kill
	 */
	public void doDamage() {
		if (!hasIFrames) {
			if (big) {
				big = !big;
				isShrinking = true;
				hasIFrames = true;
			} else if (!isDieing) {
				kill();
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Entity#getVelocityY()
	 */
	@Override
	public double getVelocityY() {
		return vely;
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Entity#getVelocityX()
	 */
	@Override
	public double getVelocityX() {
		return velx;
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Entity#setVelocityX(double)
	 */
	@Override
	public void setVelocityX(double x) {
		velx = x;
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Entity#setVelocityY(double)
	 */
	@Override
	public void setVelocityY(double y) {
		vely = y;
		
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Entity#setAccX(double)
	 */
	@Override
	public void setAccX(double x) {
		accx = x;
		
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Entity#setAccY(double)
	 */
	@Override
	public void setAccY(double y) {
		accy = y;
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Entity#setLocation(java.awt.Point)
	 */
	@Override
	public void setLocation(Point p) {
		locx = p.getX();
		locy = p.getY();
	}

	/* (non-Javadoc)
	 * @see ca.brockcsc.mariomashup.Entity#setLanded()
	 */
	@Override
	public void setLanded() {
		landed = true;
	}



}
