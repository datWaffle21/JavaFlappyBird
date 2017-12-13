package com.CS.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pipe extends GameObject{
	
	private Handler handler;
	
	Color greenValue = new Color(0, 250, 0);

	public Pipe(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}

	public void tick() {
	
		x += velX;
		y += velY;
		
		}

	public void render(Graphics g) {
	
		g.setColor(greenValue);
		g.fillRect(x, y, 50, 200);
		g.fillRect(x - 8, y, 64, 28);
		
	}

	public Rectangle getBounds() {
	//	return new Rectangle(x, y, )
		return null;
	}

}
