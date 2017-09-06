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
	public String image_src;
	public float x, y;
	Image img;

	// +++ SPRITE CONSTRCTOR +++
	public Sprite(String image_src, float x, float y) throws SlickException {
		
		this.image_src = image_src;
		// The corners of the tiles need to be adjusted for the size of the tiles!
		this.x = App.TILE_SIZE * x;
		this.y = App.TILE_SIZE * y;
		
		// Associate an Image object with this sprite!
		// Probably not the best way to do this but it works for now!
		this.img = new Image(this.image_src);
	}
	
	// +++ NOT A THING YET +++
	public void update(Input input, int delta) {
	}
	
	// +++ RENDERS THIS SPRITE +++
	public void render(Graphics g, float[] offset) throws SlickException {
		this.img.draw(offset[App.WORLD_X] + this.x, offset[App.WORLD_Y] + this.y);
	}
}
