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
	
	// +++ World Variable Decs +++
	private float[] boardSize;
	public static float[] offset = new float[2];
	private ArrayList<Sprite> sprites;
	private Player player;
	
	private final int BLACK_SIDES = 2;

	/**
	 * @param filename
	 * 
	 * Constructor for the World, loads sprites, the player, and calculates the
	 * game board offset so it lives in the middle of the screen.
	 */
	public World(String filename) {
		// Load the sprites into the ArrayList and gets the size of the board.
		this.boardSize = Loader.getWorldSize(filename);
		sprites = Loader.loadSprites(filename);
		player = Loader.getPlayer();
		
		// Calculates number of pixels needed to put board in center of window
		World.offset[App.WORLD_X] = (App.SCREEN_WIDTH - (this.boardSize[App.WORLD_X] * App.TILE_SIZE)) / BLACK_SIDES;
		World.offset[App.WORLD_Y] = (App.SCREEN_HEIGHT - (this.boardSize[App.WORLD_Y] * App.TILE_SIZE)) / BLACK_SIDES;
	}
	
	/**
	 * @param input
	 * @param delta
	 * 
	 * Updates the world every delta seconds
	 */
	public void update(Input input, int delta) {
		player.update(input, delta);
	}
	
	/**
	 * @param g
	 * @throws SlickException
	 * 
	 * Renders all of the sprites in the Sprite Array,
	 * then renders the player
	 */
	public void render(Graphics g) throws SlickException {
		
		// Render all of the pieces as per the level description
		for(int i=0; i<sprites.size(); i++) {
			sprites.get(i).render(g, World.offset);
		}
		
		player.render(g, World.offset);
		
	}
}
