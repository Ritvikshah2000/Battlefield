package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.*;

public class Main extends Canvas implements Runnable {

	public static final int WIDTH = Tile.TILESIZE;
	public static final int HEIGHT = Tile.TILESIZE;

	public static int HOR_SCALE = Tile.GRIDSIZE;
	public static int VERT_SCALE = Tile.GRIDSIZE;

	public static int width = WIDTH * HOR_SCALE;
	public static int height = HEIGHT * VERT_SCALE;

	private Thread mainThread; //thread object
	private static Window window;

	public static boolean running = false; //used for thread
	
	public static boolean pause = false;

	private int frames = 0; //a console frame counter to check the efficiency of the code

	public Player player; //player object (can be reprogrammed to fit needs)
	public TestLevel level; //sample level (our game will only be a single level)
	public Images imgs; //image object
	//public Health health;
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Bomb> bombs = new ArrayList<Bomb>();
	public static ArrayList<Reward> rewards = new ArrayList<Reward>();
	public static ArrayList<HealthBar> hpBar = new ArrayList<HealthBar>();
	// public Enemy enemy1;
	// public Enemy enemy2;
	// public Enemy enemy3;


	public Dimension size = new Dimension(width, height);



	public Main() {
		player = new Player(32,32); //starting position(x,y)
		level = new TestLevel(); //instantiate
		imgs = new Images();
		Health.bar.add(new HealthBar(0,0));
		Health.bar.add(new HealthBar(32,0));
		Health.bar.add(new HealthBar(64,0));
		enemies.add(new Enemy(64, 448));
		enemies.add(new Enemy(224, 480));
		enemies.add(new Enemy(512, 96));
		
		new Window(size, this);

		addKeyListener(new Key()); //keylistener to get user input
	}
	
	public static  Window getWindow()
    {
        return window;
    }
	
	public static void main(String[] args) {
		new MainMenu();
	}

	public synchronized void start() { //start thread
		mainThread = new Thread(this);
		mainThread.start();

		running = true;
	}
	public synchronized void stop() { //stop thread
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() { //when thread is running
        long timer = System.currentTimeMillis();
        while(running)
        {
            while(pause)
            {
                System.out.println("Now the game is pausing");
                try {
                    mainThread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                mainThread.sleep(7); //caues thread to suspend execution for a specificed period. an efficient means of making processor time for other threads
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
		if(Health.bar.isEmpty())
        {
            window.dispose();
            running = false;
            new GameOverMenu();
        }		BufferStrategy bs = this.getBufferStrategy(); //items are drawn to screen using buffer strategy
		if(bs == null) { //null by default
			createBufferStrategy(3); //prevents image tearing
			return;
		}
		Graphics graphics = bs.getDrawGraphics();
		Graphics2D g = (Graphics2D) graphics;

		g.setColor(new Color(0,0,0)); //r,g,b only goes upto 255
		g.fillRect(0, 0, width, height);


		level.update(g);
		Health.update(g);
		enemies.forEach((e) -> e.update(g));
		bombs.forEach((b) -> b.update(g));
		rewards.forEach((r) -> r.update(g));
		KeyBar.update(g);
		player.update(g);
		// enemy1.update(g);
		// enemy2.update(g);
		// enemy3.update(g);

		g.dispose();
		bs.show();
	}



}//end class
