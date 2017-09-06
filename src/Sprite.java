/**
 * Project skeleton for SWEN20003: Object Oriented Software Development 2017
 * by Eleanor McMurtry
 * 
 * @author 	Luke Hedt
 * StuID: 	832153
 * Date:	03/09/2017
 * 
 */

// +++ Package Imports +++
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Sprite {
	
	// +++ VARIABLE DECS +++
	public String type;
	public String image_src;
	public float x, y;
	private Image img;
	
	// Need to reference the home of the assets
	final String LOCATION = "res";
	final String FILETYPE = "png";

	/**
	 * @param type
	 * @param image_src
	 * @param x
	 * @param y
	 * @throws SlickException
	 * 
	 * Constructor, creates a new Sprite and stores the variables appropriately
	 */
	public Sprite(String type, String image_src, float x, float y) throws SlickException {
		
		this.type = type;
		this.image_src = String.format("%s/%s.%s", LOCATION, image_src, FILETYPE);
		// The corners of the tiles need to be adjusted for the size of the tiles!
		this.x = App.TILE_SIZE * x;
		this.y = App.TILE_SIZE * y;
		
		// Associate an Image object with this sprite!
		// Probably not the best way to do this but it works for now!
		this.img = new Image(this.image_src);
	}
	
	/**
	 * @param input
	 * @param delta
	 * 
	 * Extended by Subclass
	 */
	public void update(Input input, int delta) {
	}
	
	/**
	 * @param g
	 * @param offset
	 * @throws SlickException
	 * 
	 * Renders the Sprite on the game board
	 */
	public void render(Graphics g, float[] offset) throws SlickException {
		this.img.draw(offset[App.WORLD_X] + this.x, offset[App.WORLD_Y] + this.y);
	}
}
