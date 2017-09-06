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

public class Player extends Sprite 
{
	String image_src;
	private float playerX;
	private float playerY;
	Image img;
	final private double SPEED = 0.4;
	
	public Player(String image_src, float x, float y) throws SlickException {
		super(image_src, x, y);
		this.image_src = image_src;
		// Actual pos = (block pos) * (tile size)
		this.playerX = App.TILE_SIZE * x;
		this.playerY = App.TILE_SIZE * y;
		
		this.img = new Image(this.image_src);
	}
	
	@Override
	public void update(Input input, int delta) {

		// Tests for the Up key.
		if (input.isKeyDown(Input.KEY_UP)) {
			// Y starts as 0 at top of screen, so decreasing Y is the same as going up.
			playerY -= delta * SPEED;
		}

		// Tests for the Down key
		if (input.isKeyDown(Input.KEY_DOWN)) {
			// Increasing Y == Going Down
			playerY += delta * SPEED;
		}
		
		// Tests for the Right key
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			// X starts on left side so increasing X is equal to going right
			playerX += delta * SPEED;
		}
		
		//Tests for Left Key
		if (input.isKeyDown(Input.KEY_LEFT)) {
			// Decreasing X == Going left
			playerX -= delta * SPEED;
		}
	}
	
	// +++ RENDERS THIS SPRITE +++
	public void render(Graphics g, float[] offset) throws SlickException {
		this.img.draw(offset[App.WORLD_X] + this.playerX, offset[App.WORLD_Y] + this.playerY);
	}
}
