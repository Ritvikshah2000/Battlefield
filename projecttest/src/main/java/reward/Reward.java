package reward;

import java.awt.*;


public abstract class Reward
{
    public int x, y;      // position

    public Reward(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void onHit(){

    };

    public void update(Graphics2D g){

    };

    public int getX(){ return (int)(x / 32); };
    public int getY(){ return (int)(y / 32); };
}


