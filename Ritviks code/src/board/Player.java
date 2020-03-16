package board;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
	public float x,y; //position
	public float speed = 4.5f; //rate at which player moves
	
	public static boolean movingLeft, movingRight, movingUp, movingDown;
	
	public Player(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public void update(Graphics2D g) {
		g.drawImage(Images.testplayer,(int)x,(int)y,64,64, null );
		
		//update player movement based on user input
		if(movingLeft) x -= speed;
		if(movingRight) x+= speed;
		if(movingUp) y -= speed;
		if(movingDown) y += speed;
	}
}
