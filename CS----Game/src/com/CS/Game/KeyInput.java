package com.CS.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private Player player;
	private Game game;
	private HUD hud;
	
	public static boolean down = false;

	public KeyInput(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
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
				handler.removeAll();
				Game.gameState = Game.STATE.Game;
				hud.score = 0;
				handler.addObject(new Player(370, Game.HEIGHT / 2 - 40, ID.Player, handler, hud));
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