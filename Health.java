package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Health {
	public int hp = 100;
	
	public void update(Graphics2D g) {
		g.setColor(Color.PINK);
		g.fillRect(25, 25, hp*2, 50);
}
	}

