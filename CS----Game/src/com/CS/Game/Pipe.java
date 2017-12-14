package com.CS.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pipe extends GameObject{
	
	private Handler handler;
	
	Color greenValue = new Color(0, 180, 0);

	public Pipe(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = -3;
		velY = 0;
	}

	public void tick() {
	
		x += velX;
		y += velY;
		
		}

	public void render(Graphics g) {
	
		g.setColor(greenValue);
		g.fillRect(x, y, 50, 300);
		g.fillRect(x - 8, y, 64, 28);
		
		g.setColor(Color.red);
	//	g.drawRect(x - 10 , y, 64, 248); // hit box for pipe
	//	g.drawRect(x + 50, 0, 2, Game.HEIGHT); // hitbox for the point system
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x - 10 , y, 64, 248);
	}
	
	public Rectangle getLine() {
		return new Rectangle(x + 50, 0, 2, Game.HEIGHT);
	}

}