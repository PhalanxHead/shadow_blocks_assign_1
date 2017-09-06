/**
 * @author lhedt
 * StuID: 832153
 * 
 * Class for the player object as it has more functionality than typical tiles.
 */


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player extends Sprite {
	String image_src;
	private float playerX;
	private float playerY;
	Image img;
	final private double SPEED = 0.4;
	
	public Player(String type, String image_src, float x, float y) throws SlickException {
		super(type, image_src, x, y);
		this.type = type;
		this.image_src = String.format("%s/%s.%s", LOCATION, image_src, FILETYPE);
		// Actual pos = (block pos) * (tile size)
		this.playerX = App.TILE_SIZE * x;
		this.playerY = App.TILE_SIZE * y;
		
		this.img = new Image(this.image_src);
	}
	
	@Override
	public void update(Input input, int delta) {

		// Tests for the Up key.
		if (input.isKeyPressed(Input.KEY_UP)) {
			// Y starts as 0 at top of screen, so decreasing Y is the same as going up.
			playerY -= App.TILE_SIZE;
		}

		// Tests for the Pressed key
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			// Increasing Y == Going Pressed
			playerY += App.TILE_SIZE;
		}
		
		// Tests for the Right key
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			// X starts on left side so increasing X is equal to going right
			playerX += App.TILE_SIZE;
		}
		
		//Tests for Left Key
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			// Decreasing X == Going left
			playerX -= App.TILE_SIZE;
		}
	}
	
	// +++ RENDERS THIS SPRITE +++
	public void render(Graphics g, float[] offset) throws SlickException {
		this.img.draw(offset[App.WORLD_X] + this.playerX, offset[App.WORLD_Y] + this.playerY);
	}
}
