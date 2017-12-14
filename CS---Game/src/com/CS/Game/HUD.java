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
	
	public double score = 0.0;
	
	public void render(Graphics g) {
		Font font = new Font("arial", 1, 125);
		Font font2 = new Font("arial", 1, 75);
		Font small = new Font("arial", 1, 25);
		
		if(Game.gameState == Game.STATE.Game) {
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("" + ((int) score), Game.WIDTH / 2 - 30, 125);
		} else if(Game.gameState == Game.STATE.End) {
	
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Your final score was: " + ((int) score), 100, 300);
		}
		
		g.setFont(small);
		g.drawString("" + Game.frameCount, 5, 23);
		
		
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public double getScore() {
		return score;
	}
	
}
