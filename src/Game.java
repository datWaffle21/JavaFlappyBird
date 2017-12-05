import java.awt.Canvas;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	public static final int WIDTH = 1500, HEIGHT = (WIDTH / 12 * 9);
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private Random r;
	
	public Game() {
		
		handler = new Handler();
		//menu = new Menu(this, handler);
	//	this.addKeyListener(new KeyInput(handler));
	//	this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "Flappy Bird", this);
		
		r= new Random();
		
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
		handler.tick();
		
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
				System.out.println("FRAMES: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	
	
}
