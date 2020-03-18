<<<<<<< HEAD
package main;
=======

>>>>>>> 9e71ed87c99fe336f79dcf3d235c1347eec2d5aa
import java.awt.*;

public class Freeze extends Reward
{
    private int freezetime = 90;
    private int timeLeft = 750;


    public Freeze(int x, int y)
    {
        super(x * 32, y * 32);
        value = 150;
    }

    public void onHit(){
      Main.enemies.forEach((e) -> e.frozenTimer = freezetime);
      Player.score += value;
      Score.update();
  		TestLevel.addGrass(getX(), getY());
      Main.rewards.remove(this);
    }

    public void update(Graphics2D g){
      if(timeLeft > 0){
        g.drawImage(Images.testFreeze, x, y, 32, 32, null);
        timeLeft -= 1;
      }else{
        TestLevel.addGrass(getX(), getY());
      }
    }


}
