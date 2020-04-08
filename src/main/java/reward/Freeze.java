package reward;

import actor.Player;
import actor.Score;
import board.TestLevel;
import image.Images;
import music.FreezeSound;
import playgame.Main;

import java.awt.*;

public class Freeze extends Reward
{
    private int freezetime = 180;
    private int timeLeft = 750;
    private FreezeSound freezesound;

    public Freeze(int x, int y)
    {
        super(x * 32, y * 32);
        value = 150;
    }

    public void onHit(){
        this.freezesound = new FreezeSound();
        Main.getEnemy().forEach((e) -> e.frozenTimer = freezetime);
        Player.setScore(value);
        Score.update();
        TestLevel.addGrass(getX(), getY());
        Main.getRewards().remove(this);
    }

    public void update(Graphics2D g){
        if(timeLeft > 0){
            g.drawImage(Images.getFreezeImage(), x, y, 32, 32, null);
            timeLeft -= 1;
        }else{
            TestLevel.addGrass(getX(), getY());
        }
    }
}