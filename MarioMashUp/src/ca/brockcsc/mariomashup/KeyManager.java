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

import java.awt.event.KeyEvent;
import java.util.EnumMap;

/**
 * Manages accessing key presses from
 * a global context singleton class
 * @author brad
 * @version 1.0
 * @since Aug 6, 2016
 */
public class KeyManager {
	
	private static KeyManager km;
	private EnumMap<Keys, Boolean> keymap;
	
	
	public enum Keys {
		UP,
		DOWN,
		LEFT,
		RIGHT,
		A,
		B,
		START,
		SUPER,
	}
	
	private KeyManager() {
		keymap = new EnumMap<Keys, Boolean>(Keys.class);
	}
	
	/**
	 * @return the only instance of KeyManager
	 */
	public static KeyManager getInstance() {
		if (km == null) {
			km = new KeyManager();
		}
		return km;
	}
	
	/**
	 * Get the current state of the given key
	 * @param k key
	 * @return true if the button is depressed
	 */
	public synchronized boolean getKey(Keys k) {
		return keymap.getOrDefault(k, false);
	}
	
	/** 
	 * Update the KeyManager with keys pressed
	 * @param k
	 */
	public synchronized void signal(KeyEvent k) {
		Keys key = keybindings(k);
		if (key == null) {
			return;
		}
		if (k.getID() == KeyEvent.KEY_PRESSED) {
			keymap.put(key, true);
		} else if (k.getID() == KeyEvent.KEY_RELEASED) {
			keymap.put(key, false);
		}
	}
	
	private static Keys keybindings(KeyEvent k) {
		switch(k.getKeyChar()) {
		case 'w':
			return Keys.UP;
		case 'a':
			return Keys.LEFT;
		case 's':
			return Keys.DOWN;
		case 'd':
			return Keys.RIGHT;
		case '.':
			return Keys.B;
		case '/':
			return Keys.A;
		default:
			return null;
		}
	}
}
