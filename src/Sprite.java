/**
 * Project skeleton for SWEN20003: Object Oriented Software Development 2017
 * by Eleanor McMurtry
 * 
 * @author 	Luke Hedt
 * StuID: 	832153
 * Date:	03/09/2017
 * 
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Sprite {
	public String image_src;
	public float x, y;
	Image img;

	public Sprite(String image_src, float x, float y) throws SlickException {
		this.image_src = image_src;
		this.x = App.TILE_SIZE * x;
		this.y = App.TILE_SIZE * y;
		
		this.img = new Image(this.image_src);
	}
	
	public void update(Input input, int delta) {
	}
	
	public void render(Graphics g) throws SlickException {
		this.img.draw(this.x, this.y);
	}
}
