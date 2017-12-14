package com.CS.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private Player player;
	private Game game;
	
	public static boolean down = false;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			if(key == KeyEvent.VK_SPACE) {
			//	Player.velY *= -1; 
				//Player.velY -= Player.upwardThrust;
				down = true;
			}
		}
		
		if(Game.gameState == Game.STATE.End) {
			if(key == KeyEvent.VK_ENTER) {
				new Game();
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			if(key == KeyEvent.VK_SPACE) {
			//	Player.velY *= -1; 
				//Player.velY += Player.upwardThrust;
				down = false;
				
		
			}
		}
	}
	
	
}