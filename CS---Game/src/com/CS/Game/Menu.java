package com.CS.Game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {

	private Handler handler;
	private Game game;
	private HUD hud;
	
	public Menu(Handler handler, Game game, HUD hud) {
		this.handler = handler;
		this.game = game;
		this.hud = hud;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(Game.gameState == Game.STATE.Menu) {
			Font font = new Font("arial", 1 ,144);
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Click to Play", 75, 580);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == Game.STATE.Game) {
			if(mouseOver(mx, my, 0 , 0, Game.WIDTH, Game.HEIGHT)) {
				KeyInput.down = true;
			}
		}
		
		if(Game.gameState == Game.STATE.Menu) {
			if(mouseOver(mx, my, 0, 0, Game.WIDTH, Game.HEIGHT )) {
				Game.gameState = Game.STATE.Game;
				handler.addObject(new Player(320, 200, ID.Player, handler, hud));
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == Game.STATE.Game) {
			if(mouseOver(mx, my, 0 , 0, Game.WIDTH, Game.HEIGHT)) {
				KeyInput.down = false;
			}
		}
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
