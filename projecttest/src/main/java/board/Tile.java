package board;

import image.Images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Tile extends Rectangle {

    public int id;
    public boolean barrier;

    public static final int GRIDSIZE = 60; //contains 60 tiles
    public static final int TILESIZE = 16; //becasue every image in the spritesheet is 16x16

    public Tile(int id, Rectangle boundaries, boolean barrier) {
        setBounds(boundaries);
        this.id = id;
        this.barrier = barrier;
    }

    public boolean isBarrier() {return barrier; };
    //the switch case is in order to have separate levels, but we can adjust it to our needs
    public void update(Graphics2D g)
    {
        switch(this.id)
        {
            case -1: //without any textures
                g.setColor(new Color(243,184,122));
                g.fillRect(x, y, width, height);
                break;
            case 0: //base textures
                g.drawImage(Images.tilesheet,  x,  y,  width,  height,  null); // ？
                break;
            case 1:
                g.drawImage(Images.tiles[0],  x,  y,  width,  height,  null);   // grass
                break;
            case 2:
                g.drawImage(Images.tiles[1],  x,  y,  width,  height,  null);   // horiz barrier
                break;
            case 3:
                g.drawImage(Images.tiles[2],  x,  y,  width,  height,  null);   // verti barrier
                break;
            default:
                break;
        }

    }
}
