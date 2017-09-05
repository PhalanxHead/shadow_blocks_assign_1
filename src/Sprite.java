/**
 * Project skeleton for SWEN20003: Object Oriented Software Development 2017
 * by Eleanor McMurtry
 * 
 * @author 	Luke Hedt
 * StuID: 	832153
 * Date:	03/09/2017
 * 
 */

import org.newdawn.slick.Input;
import org.newdawn.slick.Graphics;

public class Sprite {
	public String image_src;
	public float x, y;

	public Sprite(String image_src, float x, float y) {
		this.image_src = image_src;
		this.x = x;
		this.y = y;
	}
	
	public void update(Input input, int delta) {
	}
	
	public void render(Graphics g) {
	}
}
