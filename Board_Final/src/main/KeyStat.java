package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class KeyStat {

	public static int noOfKey = 0;

	  public void update(Graphics2D g){
	    g.setColor(Color.yellow);
	    g.fillRect(90, 90, noOfKey, 50);
	  }
}
