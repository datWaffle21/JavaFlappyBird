package com.CS.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	private Handler handler;
	

	public Player(int x, int y, ID id, Handler handler) {
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
	
		if(y >= Game.HEIGHT - 72)  {
			handler.removeAll();
			Game.gameState = Game.STATE.End;
		}
		if(y <= 0)  {
			handler.removeAll();
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
		
		if(Game.gameState == Game.STATE.End) {
			handler.removeObject(this);
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