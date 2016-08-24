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

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.ArrayList;


/**
 * @author brad
 * @version 1.0
 * @since Aug 5, 2016
 */
public class Viewport extends Canvas implements Runnable {
	private static final long serialVersionUID = -109194424346100897L;
	private ArrayList<ArrayList<Drawable>> layers;
	private ArrayList<Entity> entities;
	
	private Point topcorner;
	
	private int minYForDeath;
	private static final boolean KILLFALLERS = true;
	
	
	private boolean running;
	private Thread thread;
	
	Viewport() {
		this(5);
	}
	
	Viewport(int numlayers) {
		// Set corner
		topcorner = new Point(0, 0);
		// Generate the layers
		layers = new ArrayList<>();
		entities = new ArrayList<>();
		for (int i = 0; i < numlayers; ++i)
			layers.add(new ArrayList<>());
		// Load the map in layers and entities
		minYForDeath = MapReader.readMap(new File("test-map.txt"), layers, entities);
	}

	public void start() {
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	
	public void stop() {
		running = false;
		try{
			thread.join();
		} catch(Exception e) {}
	}
	
	@Override
	public void run() {
		createBufferStrategy(2);
		BufferStrategy strategy = getBufferStrategy(); 
		long lastLoopTime = System.currentTimeMillis();
		long currentTime;
		long delta;
		Graphics graphics;
		while (running) {
			currentTime = System.currentTimeMillis();
			delta = currentTime - lastLoopTime;
			lastLoopTime = currentTime;
			update(delta);
			graphics = strategy.getDrawGraphics();
			draw(graphics);
			graphics.dispose();
			strategy.show();
			/*if (delta < 2) try { 
				Thread.sleep(2-delta); 
			} catch (Exception e) {};*/
		}
	}
	
	/**
	 * Update the drawable objects internal state so the
	 * objects know how much time has passed and which frame to display
	 * @param delta
	 */
	private void update(long delta) {
		for(Entity e: entities) {
			// If offscreen kill the Hero
			if (KILLFALLERS && e instanceof Hero && e.getBoundingBox().getMaxY() > minYForDeath) {
				((Hero) e).kill();

				System.out.println("Killed");
			}
			// Make sure the entity is on screen
			Rectangle r = e.getBoundingBox();
			for(ArrayList<Drawable> layer: layers) {
				for(Drawable d: layer) {
					// Dont let objects collide with themselves
					if (d == e) {
						continue;
					}
					if (d instanceof Collidable && ((Collidable) d).getBoundingBox().intersects(r)) {
						((Collidable) d).actionCollision(e);
					}
				}
			}
		}
		// Update all drawable objects
		for(ArrayList<Drawable> layer: layers) {
			for(Drawable d: layer) {
				d.update(delta);
			}
		}
		// Move all drawable objects
		for(ArrayList<Drawable> layer: layers) {
			for(Drawable d: layer) {
				d.move(delta);
			}
		}
	}
	
	/** 
	 * Draw the graphics layers bottom to top
	 * @param graphics
	 */
	private void draw(Graphics graphics) {
		Rectangle viewport = new Rectangle(topcorner, this.getSize());
		Rectangle safe = new Rectangle(viewport);
		int safewidth = 128;
		safe.grow(-safewidth, 0);
		// Check that all heros are within the viewport
		for(Entity e: entities) {
			if (!(e instanceof Hero)) continue;
			
			if (!safe.contains(e.getBoundingBox())) {
				if (safe.getCenterX() > e.getBoundingBox().getCenterX()) { // Leaving from left
					topcorner.x = e.getBoundingBox().x - safewidth;
				} else { // Leaving from right
					topcorner.x = (int) (e.getBoundingBox().getMaxX() - safe.width - safewidth);
				}
				viewport = new Rectangle(topcorner, this.getSize());
				safe = new Rectangle(viewport);
				safe.grow(-safewidth, 0);
			}
		}

		graphics.setColor(new Color(183, 165, 255));
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Example of how to draw fonts
		graphics.setColor(Color.WHITE);
		// graphics.drawString(String.format("%d-%d",  viewport.x, viewport.y), 0, 30);
		
		for(ArrayList<Drawable> layer: layers) {
			for(Drawable d: layer) {
				d.draw(graphics, viewport);
			}
		}
	
	}
}
