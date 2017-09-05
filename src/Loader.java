/**
 * Project skeleton for SWEN20003: Object Oriented Software Development 2017
 * by Eleanor McMurtry
 * 
 * @author 	Luke Hedt
 * StuID: 	832153
 * Date:	03/09/2017
 * 
 */

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
		String img = "res/floor.png";
		float x=5,y=10;
		Sprite sprites[] = new Sprite[5];
		
		sprites[0] = new Sprite(img, x, y);
		
		System.out.printf("%s, %f, %f", sprites[0].image_src, sprites[0].x, sprites[0].y);
		
		// Need Scanner or ReadBuffer
		return null;
	}
}
