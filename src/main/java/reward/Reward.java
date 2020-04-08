package reward;

import board.Tile;

import java.awt.Graphics2D;


public abstract class Reward
{
    private int x;
    private int y;
    private int value;

    public Reward(final int dx, final int dy)
    {
        x = dx;
        y = dy;
    }

    public void onHit(){

    };

    public void update(final Graphics2D g){

    };

    public final int getXIndex(){ return (int)(x / Tile.TILESIZE); };
    public final int getYIndex(){ return (int)(y / Tile.TILESIZE); };
    public final int getX(){ return x; };
    public final int getY(){ return y; };
}
