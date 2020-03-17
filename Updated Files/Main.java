package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Main extends Canvas implements Runnable {

	public static final int WIDTH = Tile.TILESIZE;// tilesize
	public static final int HEIGHT = Tile.TILESIZE;

	public static int HOR_SCALE = Tile.GRIDSIZE;// no of tiles
	public static int VERT_SCALE = Tile.GRIDSIZE;

	public static int width = 1440;
	public static int height = 896;

	private static Thread thread; //thread object MADE STATIC AND STOP ALSO MADE STATIC

	public static boolean running = false; //used for thread

	private int frames = 0; //a console frame counter to check the efficiency of the code

	public Player player; //player object (can be reprogrammed to fit needs)
	public TestLevel level; //sample level (our game will only be a single level)
	public Images imgs; //image object
	public Health healthBar;
	public static ArrayList<Enemy> enemies;
	public static ArrayList<Bomb> bombs;
	// public Enemy enemy1;
	// public Enemy enemy2;
	// public Enemy enemy3;


	public Dimension size = new Dimension(width, height);



	public Main() {
		player = new Player(600,600); //starting position(x,y)
		level = new TestLevel(); //instantiate
		imgs = new Images();
		healthBar = new Health();
		enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy(100, 100));
		enemies.add(new Enemy(300, 500));
		enemies.add(new Enemy(900, 600));
		bombs = new ArrayList<Bomb>();
		bombs.add(new HealthBomb(200,200));
		bombs.add(new ScoreBomb(700, 800));

		addKeyListener(new Key()); //keylistener to get user input

		//enemy1 = new Enemy(100, 100);
		//enemy2 = new Enemy(500, 500);
		//enemy3 = new Enemy(900, 600);
		new Window(size, this);
	}
	public static void main(String[] args) {
		new Main();
	}

	public synchronized void start() { //start thread
		thread = new Thread(this);
		running = true;
		thread.start();

	}
	public static synchronized void stop() { //stop thread
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
				//System.out.println("FPS: " + frames);
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
		healthBar.update(g);
		enemies.forEach((e) -> e.update(g));
		bombs.forEach((e) -> e.update(g));
		player.update(g);
		
		// enemy1.update(g);
		// enemy2.update(g);
		// enemy3.update(g);

		g.dispose();
		bs.show();
	}



}//end class