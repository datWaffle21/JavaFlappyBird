package com.CS.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	private Handler handler;
	private HUD hud;	

	public Player(int x, int y, ID id, Handler handler, HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
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
	
		if(y >= 625 - 40)  {
			setY(625 - 36);
			Game.gameState = Game.STATE.End;
		}
		if(y <= 0)  {
			Game.gameState = Game.STATE.End;
		}
		
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
		collison();
		
		if(y >= 625 - 40 || y <= 0) {
			handler.removeObject(this);
		}
	}


	public void render(Graphics g) throws IOException {
	
		
		Image img = ImageIO.read(new File("background.png"));
		
		g.drawImage(img, x, y, null);
		
		g.setColor(Color.red);
//		g.drawRect(x + 2, y, 46, 37); // hit box for player
//		g.drawRect(x, y, 2, 2); // hit box for the point system
		
	}
	
	private void collison() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Pipe) {
				if(getBounds().intersects(tempObject.getBounds())) {
					// collison code
					Game.gameState = Game.STATE.End;
					handler.removeObject(this);
				}
			}
		}
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Pipe) {
				if(getLine().intersects(tempObject.getLine())) {
					// collison code
					hud.score += .5;
				}
			}
		}
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public Rectangle getLine() {
		return new Rectangle(x, y, 2, 2);
	}


	
}