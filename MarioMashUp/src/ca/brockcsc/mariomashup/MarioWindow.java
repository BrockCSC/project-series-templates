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

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * Interfaces for the Mario window
 * @author brad
 * @version 1.0
 * @since Aug 8, 2016
 */
public class MarioWindow {

	private static final int SCREEN_WIDTH = 320;
	private static final int SCREEN_HEIGHT = 280;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					MarioWindow window = new MarioWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarioWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mario Mashup");
		frame.setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		KeyAdapter ka = new KeyAdapter() {
			KeyManager km = KeyManager.getInstance();
			@Override
			public void keyPressed(KeyEvent k) {
				km.signal(k);
			}
			@Override
			public void keyReleased(KeyEvent k) {
				km.signal(k);
			}
		};
		
		frame.addKeyListener(ka);
		
		Viewport canvas = new Viewport();
		canvas.addKeyListener(ka);
		frame.getContentPane().add(canvas);
		frame.setVisible(true);

		canvas.start();
		
	}

}
