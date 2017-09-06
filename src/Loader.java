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

public class Loader {	
	// Converts a world coordinate to a tile coordinate,
	// and returns if that location is a blocked tile
	public static boolean isBlocked(float x, float y) {
		// Default to blocked
		return true;
	}
		
	/**
	 * Loads the sprites from a given file.
	 * @param filename
	 * @return
	 */
	public static Sprite[] loadSprites(String filename) {
		

		String[] out = new String[3];
		Float[] worldSize = new Float[2];
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		Sprite currSprite;
		
		try (BufferedReader br =
			new BufferedReader(new FileReader(filename))) {
			
			String lvlLine;
			
				if((lvlLine = br.readLine()) != null) {
					worldSize[0] = Float.parseFloat(lvlLine.split(",")[0]);
					worldSize[1] = Float.parseFloat(lvlLine.split(",")[1]);
				}
				
				while ((lvlLine = br.readLine()) != null) {
					
					out[0] = lvlLine.split(",")[0];
					out[1] = lvlLine.split(",")[1];
					out[2] = lvlLine.split(",")[2];
					
					currSprite = new Sprite(out[0], Float.parseFloat(out[1]), Float.parseFloat(out[2]));
					sprites.add(currSprite);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
}
