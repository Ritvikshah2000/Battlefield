package main;
import java.awt.*;

public abstract class Reward
{
    public int x, y;      // position
    
    public Reward(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public abstract void onHit();

    public abstract void update(Graphics2D g);
}
