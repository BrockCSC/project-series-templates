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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * Manages loading images and getting them from
 * any context
 * @author brad
 * @version 1.0
 * @since Aug 6, 2016
 */
public class GraphicManagerSingleton {

	private static GraphicManagerSingleton i;
	
	private HashMap<String, BufferedImage> staticmap;
	private HashMap<String, ArrayList<BufferedImage>> animatedmap;
	
	private GraphicManagerSingleton() {
		staticmap = new HashMap<>();
		animatedmap = new HashMap<>();
		
		readSettings();

	}

	public static GraphicManagerSingleton getInstance() {
		if (i == null)
			i = new GraphicManagerSingleton();
		return i;
	}
	
	public BufferedImage retrieveImage(String img) {
		return staticmap.get(img);
	}
	public BufferedImage retrieveImageFrame(String img, int frame) {
		return animatedmap.get(img).get(frame);
	}
	
	private void readSettings() {
		Scanner s = null;
		try {
			s = new Scanner(new File("sprite/settings.txt"));
		} catch (FileNotFoundException e) {
			System.err.format("Cannot read sprite/settings.txt \n%s\n", e);
			System.exit(1);
		}
		while(s.hasNext()) {
			String filename = s.next();
			String type = s.next();
			String engine = s.next();
			int pixels = s.nextInt();
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File("sprite/" + filename));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			if (type.equals("static")) {
				readStatic(filename.split("\\.")[0], img, engine, pixels);
			} else if (type.equals("animated")) {
				readAnimationFlipped(filename.split("\\.")[0], img, engine, pixels, pixels * 2);
			} else {
				System.err.println("Not a valid type");
				System.exit(1);
			}
			
		}
		
	}
	
	private void readStatic(String prefix, BufferedImage img, String engine, int pixels) {
		for (int row = 0; row < img.getHeight() / pixels; ++row) {
			for (int col = 0; col < img.getWidth() / pixels; ++col) {
				BufferedImage bf = img.getSubimage(col * pixels, row * pixels, pixels, pixels);
				staticmap.put(String.format("%s-%d-%d", prefix, row, col), bf);
			}
		}
	}
	
	private void readAnimationFlipped(String prefix, BufferedImage img, String engine, int pixelsx, int pixelsy) {
		ArrayList<BufferedImage> buffer = new ArrayList<>();
		for(int i = 0; i < img.getWidth() / (pixelsx * 2); ++i) {
			buffer.add(null);
		}
		for (int row = 0; row < img.getHeight() / pixelsy; ++row) {
			animatedmap.put(prefix + "-" + row + "-" + "l", new ArrayList<BufferedImage>(buffer));
			animatedmap.put(prefix + "-" + row + "-" + "r", new ArrayList<BufferedImage>(buffer));
			for (int col = 0; col < img.getWidth() / pixelsx; ++col) {
				BufferedImage bf = img.getSubimage(col * pixelsx, row * pixelsy, pixelsx, pixelsy);
				// TODO simplify this
				if (col < (img.getWidth() / pixelsx) / 2) 
					animatedmap.get(prefix + "-" + row + "-" + "l").set(((img.getWidth() / pixelsx) / 2) - 1 - col, bf);
				else
					animatedmap.get(prefix + "-" + row + "-" + "r").set(col - ((img.getWidth() / pixelsx) / 2), bf);
			}
		}
	}
}
