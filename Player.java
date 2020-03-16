package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
	public static float x,y; //position
	public float speed = 4.5f; //rate at which player moves
	public static int width, height;
	
	public static boolean movingLeft, movingRight, movingUp, movingDown;
	
	public Player(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public void update(Graphics2D g) {
		g.setColor(new Color(222,159,12)); // color for now, until we add a texture
		g.fillRect((int)x, (int)y, 75, 75);
		
		//update player movement based on user input
		if(movingLeft) x -= speed;
		if(movingRight) x+= speed;
		if(movingUp) y -= speed;
		if(movingDown) y += speed;
	}
	public Rectangle hitbox() {
		return new Rectangle((int) x, (int) y, width, height );
	}
}
