package com.CS.Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;


	public static final int WIDTH = 1000, HEIGHT = (WIDTH / 12 * 9);
	
	
	private Handler handler;
	private Spawn spawn;
	private Menu menu;
	private HUD hud;
	
	private Thread thread;
	private boolean running = false;
	
	public enum STATE {
		Game,
		Menu,
		End;
	}
	
	public static STATE gameState = STATE.Menu;
	
	private Random r;
	
	public Game() {
		
		handler = new Handler();
		hud = new HUD(handler);
		this.addKeyListener(new KeyInput(handler));
		menu = new Menu(handler, this);
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "Flappy Bird", this);
		
	//	handler.addObject(new Player(WIDTH / 2, HEIGHT / 2, ID.Player, handler));
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		
		if(gameState == STATE.Game) {
			handler.tick();
			
		} else {
		}
		hud.tick();
		menu.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Image img = new ImageIO.read(new File("background.png"));
		
		g.drawImage(, 0, 0, null);
		//g.fillRect(0, 0, WIDTH, HEIGHT);
		
		

		handler.render(g);
		
		hud.render(g);
		
		menu.render(g);
		
		g.dispose();
		bs.show();		
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.nanoTime();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();

				delta--;
			}
			if(running) {
				render();
			frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	public static float clamp(float var, int min, int max) {
		if(var >= max) {
			return var = max;
		} else if(var <= min) {
			return var = min;
		} else {
			return var;
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}