package reward;

import actor.Player;
import actor.Score;
import board.TestLevel;
import board.Tile;
import image.Images;
import music.FreezeSound;
import playgame.Main;
import java.awt.Graphics2D;

public final class Freeze extends Reward
{
    private int freezeTime = 180;
    private int timeLeft = 750;

    public Freeze(final int x, final int y)
    {
        super(x * Tile.TILESIZE, y * Tile.TILESIZE);
        value = 150;
    }

    public void onHit(){
        FreezeSound freezeSound = new FreezeSound();
        Main.getEnemy().forEach((e) -> e.setFrozenTimer(freezeTime));
        Player.setScore(value);
        Score.update();
        TestLevel.addGrass(getXIndex(), getYIndex());
        Main.getRewards().remove(this);
    }

    public void update(final Graphics2D g){
        if(timeLeft > 0){
            g.drawImage(Images.getFreezeImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE, null);
            timeLeft -= 1;
        }else{
            TestLevel.addGrass(getXIndex(), getYIndex());
        }
    }
}
