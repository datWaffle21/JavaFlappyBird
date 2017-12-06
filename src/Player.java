import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	private Handler handler;
	

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	private void gravity() {
		if(velY != 15) {
			velY += .8;
		}
	}


	public void tick() {
		y += velY;
		
		velY = Game.clamp(velY, -15, 15);
	
		gravity();
	
		if(y >= Game.HEIGHT - 72) velY *= -1;
		if(y <= 0) velY = (float) Math.sqrt(velY * velY);
		
		if(KeyInput.down) { // need to tweak numbers. they don't feel good in the game
			if(velY > 6) {
				velY *= -1;
				velY -= 1;
			} else {
				velY = 7;
				velY *= -1;
				velY -= 1;			
			}
			
			
			KeyInput.down = false;
		}
	}


	public void render(Graphics g) {
	
		g.setColor(Color.white);
		g.fillOval((int)x, (int)y, 32, 32);
		
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}


	
}
