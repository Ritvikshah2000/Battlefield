package actor;

import board.Tile;
import image.Images;

import java.awt.Graphics2D;


public final class HealthBar{

    private int x;
    private int y;

    public HealthBar(final int x, final int y){
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void update(final Graphics2D g){
        g.drawImage(Images.getHeartsImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE,null);
    }
}



