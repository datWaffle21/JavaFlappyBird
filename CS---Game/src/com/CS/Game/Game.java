package com.CS.Game;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.*;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 1000, HEIGHT = (WIDTH / 12 * 9);
	
	private boolean ran = false;
	
	private Handler handler;
	private Spawn spawn;
	private Menu menu;
	private HUD hud;
	
	private Thread thread;
	private boolean running = false;
	
	public static int frameCount;
	
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
		menu = new Menu(handler, this, hud);
		spawn = new Spawn(handler);
		
		if(!ran) new Window(WIDTH, HEIGHT, "Flappy Bird", this);

		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
	
		ran = true;
	//	handler.addObject(new Player(WIDTH / 2, HEIGHT / 2, ID.Player, handler));
	}
	
	public void tick() {		
		if(gameState == STATE.Game) {
			handler.tick();	
			spawn.tick();
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
		
//		Image img = ImageIO.read(new File("background.png"));
		
//		g.drawImage(img, 0, 0, null);
		
		Color blue = new Color(30, 144, 255);
		Color green = new Color(13, 230, 27);
		Color dGreen = new Color(12, 180, 20);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		g.setColor(green);
		g.fillRect(0, 650, WIDTH, 200);
		
		g.setColor(dGreen);
		g.fillRect(0, 621, WIDTH, 29);
		
		g.setColor(blue);
		g.fillRect(0, 0, WIDTH, 621);
		

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
		long timer = System.currentTimeMillis();
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
				frameCount = frames;
				frames = 0;
			}
		}
		try {
			stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() throws java.lang.Exception {
		try {
			thread.join();
			running = false;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
