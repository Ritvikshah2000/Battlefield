package reward;

import board.TestLevel;
import board.Tile;
import image.Images;
import playgame.Main;

import java.awt.*;

public class Freeze extends Reward
{
    private int freezetime = 90;
    private int timeLeft = 500;


    public Freeze(int x, int y)
    {
        super(x * 32, y * 32);
    }

    public void onHit(){
        Main.enemies.forEach((e) -> e.frozenTimer = freezetime);
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


