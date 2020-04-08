package playgame;

import actor.*;
import board.TestLevel;
import board.Tile;
import hazard.Bomb;
import image.Images;
import music.BGM;
import music.Losing;
import reward.Reward;
import window.GameOverMenu;
import window.MainMenu;
import window.Window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;



public class Main extends Canvas implements Runnable {
    // size
    public static final int WIDTH = Tile.TILESIZE;
    public static final int HEIGHT = Tile.TILESIZE;
    public static int HOR_SCALE = Tile.GRIDSIZE;
    public static int VERT_SCALE = Tile.GRIDSIZE;
    public static int width = WIDTH * HOR_SCALE;
    public static int height = HEIGHT * VERT_SCALE;
    public Dimension size = new Dimension(width, height);

    // functional
    private static Thread mainThread; //thread object
    private static Window window;
    private static boolean running = false; //used for thread
    private static boolean pause = false;
    private Images imgs; //image object
    private static Graphics2D g;

    // music
    private static BGM bgm;
    private static Losing losingsound;

    // game component
    private static Player player; //player object (can be reprogrammed to fit needs)
    private static TestLevel level; //sample level (our game will only be a single level)
    private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private static ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    private static ArrayList<Reward> rewards = new ArrayList<Reward>();
    private static Health health;

    // Constructor
    public Main(int mapindex){
        if (mapindex == 1) {    // first map
            player = new Player(1 * Tile.TILESIZE, 1 * Tile.TILESIZE); //starting position(x,y)
            level = new TestLevel(mapindex); //instantiate
            imgs = new Images();

            health = new Health();

            enemies.add(new Enemy(2 * Tile.TILESIZE, 14 * Tile.TILESIZE));
            enemies.add(new Enemy(7 * Tile.TILESIZE, 15 * Tile.TILESIZE));
            enemies.add(new Enemy(16 * Tile.TILESIZE, 3 * Tile.TILESIZE));  // 3 enemies on the board

            window = new Window(size, this);
            bgm = new BGM();       // start bgm;
            addKeyListener(new Key()); //keylistener to get user input
        }
        else if(mapindex == 2)  // second map
        {
            player = new Player(1 * Tile.TILESIZE, 1 * Tile.TILESIZE);
            level = new TestLevel(mapindex); //instantiate
            imgs = new Images();

            health = new Health();

            enemies.add(new Enemy(18 * Tile.TILESIZE, 7 * Tile.TILESIZE));
            enemies.add(new Enemy(9 * Tile.TILESIZE, 11 * Tile.TILESIZE));
            enemies.add(new Enemy(16 * Tile.TILESIZE, 3 * Tile.TILESIZE));

            window = new Window(size, this);
            bgm = new BGM();       // start bgm;
            addKeyListener(new Key()); //keylistener to get user input
        }
    }

    /*---------------------------------getter setter---------------------------------*/

    public static  Window getWindow() { return window; }

    public static Player getPlayer() { return player; }

    public static ArrayList<Enemy> getEnemy() { return enemies; }

    public static boolean getRunning() { return running; }

    public static ArrayList<Reward> getRewards() { return rewards; }

    public static BGM getBgm() { return bgm; }

    public static Health getHealth() { return health; }

    public static boolean getPause() { return pause; }

    public static ArrayList<Bomb> getBomb() { return bombs; }

    public static void setPause(boolean b) { pause = b; }

    public static void setRunning(boolean b) { running = b; }

    /*-------------------------------------------------------------------------------*/

    public synchronized void start() { //start thread
        mainThread = new Thread(this);
        mainThread.start();
        running = true;
    }

    public void run() { //when thread is running
        long timer = System.currentTimeMillis();
        while(running) {
            while(pause) {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(7); //caues thread to suspend execution for a specificed period. an efficient means of making processor time for other threads
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            update();

            if(System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
            }
        }
    }

    public void update() { //this function basically upadtes all graphics of the game

        if(Health.getBar().isEmpty())        // check the hero health is empty or not
        {
            Main.getWindow().dispose();
            running = false;
            losingsound = new Losing();
            new GameOverMenu();
        }

        BufferStrategy bs = this.getBufferStrategy(); //items are drawn to screen using buffer strategy
        if(bs == null) {
            createBufferStrategy(3); //prevents image tearing
            return;
        }
        Graphics graphics = bs.getDrawGraphics();
        g = (Graphics2D) graphics;
        g.setColor(new Color(0,0,0)); //r,g,b only goes upto 255
        g.fillRect(0, 0, width, height);

        level.update(g);
        Health.update(g);
        enemies.forEach((e) -> e.update(g));
        bombs.forEach((b) -> b.update(g));
        rewards.forEach((r) -> r.update(g));
        KeyBar.update(g);
        player.update(g);
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new MainMenu();
    }

}//end class
