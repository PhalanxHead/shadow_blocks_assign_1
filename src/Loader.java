/**
 * Project skeleton for SWEN20003: Object Oriented Software Development 2017
 * by Eleanor McMurtry
 * 
 * @author 	Luke Hedt
 * StuID: 	832153
 * Date:	03/09/2017
 * 
 */

// +++ IMPORTS +++
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lhedt
 *
 * Loads the map from a CSV file, 
 * and contains methods to check for blocking tiles.
 */
public class Loader {
	
	// Placeholders for indexes s.t. there's no floating numbers :)
	private final static int TYPE = 0;
	private final static int IMG_X = 1;
	private final static int IMG_Y = 2;
	
	// Holds the player object for return later
	public static Player player;
	
	// Used to initialise blockedTiles array
	private static int[] worldSize = new int[2];
	// Notes where a player can't move to.
	public static boolean[][] blockedTiles;
	// Array of types that block the player.
	private static String[] blockedTypes = {"wall"};
	
	/** Converts a world coordinate to a tile coordinate,
	 * and returns if that location is a blocked tile
	 */
	public static boolean isBlocked(float x, float y) {
		
		float boardX = x / App.TILE_SIZE;
		float boardY = y / App.TILE_SIZE;
		
		if(blockedTiles[(int)boardX][(int)boardY]) {
			return true;
		}
		return false;
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
		
		/* Read in sprites from file */
		try (BufferedReader br =
			new BufferedReader(new FileReader(filename))) {
			
			String lvlLine;
			
			if((lvlLine = br.readLine()) != null) {
				worldSize[App.WORLD_X] = Integer.parseInt(lvlLine.split(",")[App.WORLD_X]);
				worldSize[App.WORLD_Y] = Integer.parseInt(lvlLine.split(",")[App.WORLD_Y]);
				
				// Initialise blocking array
				blockedTiles = new boolean[worldSize[App.WORLD_X]][worldSize[App.WORLD_Y]];
			}
				
			// Read the rest of the file and store in an ArrayList<Sprite>
			while ((lvlLine = br.readLine()) != null) {
				
				String type;
				float sprite_x;
				float sprite_y;
				
				out[TYPE] = lvlLine.split(",")[TYPE];
				out[IMG_X] = lvlLine.split(",")[IMG_X];
				out[IMG_Y] = lvlLine.split(",")[IMG_Y];

				// Calculate needed values :D
				type = out[TYPE];
				sprite_x = Float.parseFloat(out[IMG_X]);
				sprite_y = Float.parseFloat(out[IMG_Y]);
				
				// Create a player type for the player object
				if(type.equals("player")) {
					
					player = new Player(type, "player_left", sprite_x, sprite_y);
					
				} else {
					// Create a new Sprite object with the above info and add it to the ArrayList
					currSprite = new Sprite(type, type, sprite_x, sprite_y);
					sprites.add(currSprite);
				}
				
				// Determine if tile blocks the player from moving
				if(Arrays.asList(blockedTypes).contains(type)) {
					blockedTiles[Integer.parseInt(out[IMG_X])][Integer.parseInt(out[IMG_Y])] = true;
				}
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
