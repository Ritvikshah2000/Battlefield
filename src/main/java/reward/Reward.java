package reward;

import java.awt.*;


public abstract class Reward
{
    public int x, y, value;     // position

    public Reward(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void onHit(){

    };

    public void update(Graphics2D g){

    };

    public int getXIndex(){ return (int)(x / 32); };
    public int getYIndex(){ return (int)(y / 32); };
    public int getX(){ return x; };
    public int getY(){ return y; };
}
