package main;


import java.awt.Color;
import java.awt.Graphics2D;


public class Health {
  public static int hp = 1000;//INCREASED HEALTH

  public void update(Graphics2D g){
    g.setColor(Color.pink);
    g.fillRect(25, 25, hp*2, 50);

    if(hp <= 0) {//GAMEOVER IF HEALTH ZERO
        g.drawString("GAME OVER", 500, 500);// NOT WORKING FOR SOME REASON

    	Main.stop();//  (METHOD STATIC)
    }
  }
}

