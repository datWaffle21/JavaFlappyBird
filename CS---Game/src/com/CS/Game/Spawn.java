package com.CS.Game;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private GameObject gameObject;
	private Random r = new Random();
	
	public static int gameTick = 0;
	public int level = 0;
	
	public Spawn(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		gameTick++;
		
		if(gameTick > 110) {
			gameTick = 0;
			handler.addObject(new Pipe(Game.WIDTH , r.nextInt(40) + 420, ID.Pipe, handler));
			handler.addObject(new Pipe2(Game.WIDTH , r.nextInt(40) - 270, ID.Pipe, handler));
			
		}
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
