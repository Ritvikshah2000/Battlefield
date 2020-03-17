package main;

import java.awt.Graphics2D;

public abstract class Bomb {
	
	int x,y;
	
	Bomb(int x, int y) {
		this.x =x;
		this.y =y;
	}
	
	public abstract void onHit(Graphics2D g) ;
	
	public abstract void update(Graphics2D g);
	
}
