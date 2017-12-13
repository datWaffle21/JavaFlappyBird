package com.CS.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

	private Handler handler;
	

	
	public HUD(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		
	}
	
	public int score = 0;
	
	public void render(Graphics g) {
		Font font = new Font("arial", 1, 125);
		Font font2 = new Font("arial", 1, 75);
		
		if(Game.gameState == Game.STATE.Game) {
			g.setFont(font);
			g.setColor(Color.GRAY);
			g.drawString("" + score, Game.WIDTH / 2 - 30, 125);
		} else if(Game.gameState == Game.STATE.End) {
	
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Your final score was: " + score, 100, 100);
		}
		
		
		
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
}
