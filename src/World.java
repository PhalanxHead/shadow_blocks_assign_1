/**
 * Project skeleton for SWEN20003: Object Oriented Software Development 2017
 * by Eleanor McMurtry
 * 
 * @author 	Luke Hedt
 * StuID: 	832153
 * Date:	03/09/2017
 * 
 */

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	
	private float[] boardSize;
	public float[] offset = new float[2];
	ArrayList<Sprite> sprites;

	
	public World(String filename) {
		// Load the sprites into the ArrayList
		this.boardSize = Loader.getWorldSize(filename);
		sprites = Loader.loadSprites(filename);
		
		// Calculates number of pixels needed to put board in center of window
		this.offset[App.WORLD_X] = (App.SCREEN_WIDTH - (this.boardSize[App.WORLD_X] * App.TILE_SIZE)) / 2;
		this.offset[App.WORLD_Y] = (App.SCREEN_HEIGHT - (this.boardSize[App.WORLD_Y] * App.TILE_SIZE)) / 2;
	}
	
	/* Where Object-Manipulating Input can be mapped */
	public void update(Input input, int delta) {
	}
	
	/* Where you draw each element in the world */
	public void render(Graphics g) throws SlickException {
		
		// Render all of the pieces as per the level description
		for(int i=0; i<sprites.size(); i++) {
			sprites.get(i).render(g, this.offset);
		}
		
	}
}
