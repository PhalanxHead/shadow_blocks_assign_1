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
	
	ArrayList<Sprite> sprites;
	
	public World() {
		sprites = Loader.loadSprites("res/levels/0.lvl");
	}
	
	/* Where Object-Manipulating Input can be mapped */
	public void update(Input input, int delta) {
	}
	
	/* Where you draw each element in the world */
	public void render(Graphics g) throws SlickException {
		
		for(int i=0; i<sprites.size(); i++) {
			sprites.get(i).render(g);
		}
		
	}
}
