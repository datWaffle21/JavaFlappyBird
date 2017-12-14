package com.CS.Game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>(); 
	
	private HUD hud;
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) throws IOException {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void removeAll() {
		for(int i = 0; i < this.object.size(); i++) {
			GameObject tempObject = this.object.get(i);
			
			if(!(tempObject.getId() == ID.Player)) {
				this.removeObject(tempObject);
				i--;
			}
		}
	}
}