package com.CS.Game;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private GameObject gameObject;
	private Random r = new Random();
	
	public static int gameTick = 0;
	
	public Spawn(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		gameTick++;
		
		
	}
	
}
