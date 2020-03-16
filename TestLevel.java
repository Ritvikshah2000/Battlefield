package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TestLevel {
	
	public Tile[][] tiles = new Tile[50][50]; //grid
	
	public Rectangle Barrier = new Rectangle(500,500,300,300);
	
	public Enemy enemy = new Enemy(800,800);
	
	public TestLevel() {
		for(int x = 0; x < tiles.length; x++) for(int y = 0; y < tiles[0].length;y++) {
			tiles[x][y] = new Tile(1, new Rectangle( x * Tile.GRIDSIZE, y * Tile.GRIDSIZE, Tile.GRIDSIZE, Tile.GRIDSIZE)); //first argument is the id of case
			if(tiles[x][y].getBounds().intersects(Barrier)) {
				tiles[x][y].id = 2;
			}
		}
	}
	
	public void update(Graphics2D g) {
		for(int x = 0; x < tiles.length; x++) for(int y = 0; y < tiles[0].length;y++) {
			tiles[x][y].update(g);
		
		}
		enemy.update(g);
		}
	}

