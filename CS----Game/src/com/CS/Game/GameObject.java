package com.CS.Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected float velX;
	protected float velY;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g) throws IOException;
	public abstract Rectangle getBounds();
	public abstract Rectangle getLine();
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return this.id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public float getVelX() {
		return velX;
	}
}