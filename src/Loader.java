/**
 * Project skeleton for SWEN20003: Object Oriented Software Development 2017
 * by Eleanor McMurtry
 * 
 * @author 	Luke Hedt
 * StuID: 	832153
 * Date:	03/09/2017
 * 
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;

public class Loader {
	
	// Placeholders for indexes s.t. there's no floating numbers :)
	final static int IMG_SRC = 0;
	final static int IMG_X = 1;
	final static int IMG_Y = 2;

	// Holds the player object for return later
	public static Player player;
	
	// Converts a world coordinate to a tile coordinate,
	// and returns if that location is a blocked tile
	public static boolean isBlocked(float x, float y) {
		// Default to blocked
		return true;
	}
		
	/**
	 * Loads the sprites from a given file.
	 * @param filename
	 * @return Sprite[]
	 * 
	 * NOTE: Assumption is that the tile type matches the name of the image in the resource folder!
	 */
	public static ArrayList<Sprite> loadSprites(String filename) {
		
		String[] out = new String[3];
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		Sprite currSprite;
	
		
		// Need to reference the home of the assets
		final String LOCATION = "res";
		final String FILETYPE = "png";
		
		/*
		 * Read in sprites from file
		 */
		try (BufferedReader br =
			new BufferedReader(new FileReader(filename))) {
			
			String lvlLine;
			
			if((lvlLine = br.readLine()) != null) {
				// Skip this line, but check it exists
			}
				
			// Read the rest of the file and store in an ArrayList<Sprite>
			while ((lvlLine = br.readLine()) != null) {
				
				String image_src;
				float sprite_x;
				float sprite_y;
				
				out[IMG_SRC] = lvlLine.split(",")[IMG_SRC];
				out[IMG_X] = lvlLine.split(",")[IMG_X];
				out[IMG_Y] = lvlLine.split(",")[IMG_Y];
				
				if(out[IMG_SRC].equals("player")) {
					image_src = String.format("%s/%s.%s", LOCATION, "player_left", FILETYPE);
					sprite_x = Float.parseFloat(out[IMG_X]);
					sprite_y = Float.parseFloat(out[IMG_Y]);
					
					player = new Player(image_src, sprite_x, sprite_y);
					continue;
				}
				
				// Calculate needed values :D
				image_src = String.format("%s/%s.%s", LOCATION, lvlLine.split(",")[IMG_SRC], FILETYPE);
				sprite_x = Float.parseFloat(out[IMG_X]);
				sprite_y = Float.parseFloat(out[IMG_Y]);
				
				// Create a new Sprite object with the above info and add it to the ArrayList
				currSprite = new Sprite(image_src, sprite_x, sprite_y);
				sprites.add(currSprite);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sprites;
	}
	
	/**
	 * 
	 * @return player
	 * 
	 * Returns the player object
	 */
	public static Player getPlayer() {
		
		return Loader.player;
		
	}

	/*
	 * @param filename
	 * @return float[] worldSize
	 * 
	 * Gets the size of the game board and returns it as an array. Probably a better way of doing this but
	 * I can't think of it right now.
	 */
	public static float[] getWorldSize(String filename) {
		
		float[] worldSize = new float[2];
		
		try (BufferedReader br =
			new BufferedReader(new FileReader(filename))) {
			
			// Reads the first line of the file if it exists and stores it.
			String lvlLine;
			if((lvlLine = br.readLine()) != null) {
				worldSize[App.WORLD_X] = Float.parseFloat(lvlLine.split(",")[App.WORLD_X]);
				worldSize[App.WORLD_Y] = Float.parseFloat(lvlLine.split(",")[App.WORLD_Y]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return worldSize;
	}
	
}
