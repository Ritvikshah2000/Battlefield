package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

	public static final int WIDTH = 120;
	public static final int HEIGHT = 90;
	
	public static int SCALE = 7;
	
	public static int width = WIDTH * SCALE;
	public static int height = HEIGHT * SCALE;
	
	private Thread thread; //thread object
	
	public static boolean running = false; //used for thread
	
	private int frames = 0; //a console frame counter to check the efficiency of the code
	
	public Player player; //player object (can be reprogrammed to fit needs)
	public TestLevel level; //sample level (our game will only be a single level)
	public Images imgs; //image object
	
	
	public Dimension size = new Dimension(width, height);
	
	
	
	public Main() {
		player = new Player(100,200); //starting position(x,y)
		level = new TestLevel(); //instantiate
		imgs = new Images();
	
		new Window(size, this);
		
		addKeyListener(new Key()); //keylistener to get user input
	}
	public static void main(String[] args) {
		new Main();
	}
	
	public synchronized void start() { //start thread
		thread = new Thread(this);
		thread.start();
		
		running = true;
	}
	public synchronized void stop() { //stop thread
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() { //when thread is running
		long timer = System.currentTimeMillis();
		while(running) {
			try {
				thread.sleep(7); //caues thread to suspend execution for a specificed period. an efficient means of making processor time for other threads
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frames++;
			
			update();
			
			if(System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}
	
	public void update() { //this function basically upadtes all graphics of the game
		BufferStrategy bs = this.getBufferStrategy(); //items are drawn to screen using buffer strategy
		if(bs == null) { //null by default
			createBufferStrategy(3); //prevents image tearing
			return;
		}
		Graphics graphics = bs.getDrawGraphics();
		Graphics2D g = (Graphics2D) graphics;
		
		g.setColor(new Color(0,0,0)); //r,g,b only goes upto 255
		g.fillRect(0, 0, width, height);
		
		level.update(g);
		player.update(g);
		
		
		g.dispose();
		bs.show(); 
	}
}
