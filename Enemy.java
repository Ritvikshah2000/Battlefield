package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy {
	
	public static int x,y;
	public float velX, velY;
	public float speed = 1.5f;
	
	public static int damage = 50;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 50, 50);
		
		if(Player.x > x) {
			velX = speed;
		}
		if(Player.y > y) {
			velY = speed;
		}
		if(Player.x < x) {
			velX = -speed;
		}
		if(Player.y < y) {
			velY = -speed;
		}
		
		x += velX;
		y += velY;
	}

}
