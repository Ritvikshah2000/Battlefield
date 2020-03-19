package board;

import image.Images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Tile<T> extends Rectangle {

    public int id;
    public boolean barrier;
    public T item;


    public static final int GRIDSIZE = 20; //contains 60 tiles
    public static final int TILESIZE = 32; //becasue every image in the spritesheet is 16x16

    public Tile(int id, Rectangle boundaries, boolean barrier, T contents) {
        setBounds(boundaries);
        this.id = id;
        this.barrier = barrier;
        item = contents;
    }

    public boolean hasContents(){
        return item != null;
        //return item != null;
    }

    public T getContents(){
        return item;
    }

    public boolean isBarrier() {return barrier; };
    //the switch case is in order to have separate levels, but we can adjust it to our needs
    public void update(Graphics2D g) {
        switch(id) {
            case -1: //without any textures
                g.setColor(new Color(243,184,122));
                g.fillRect(x, y, width, height);
                break;
            case 0: //base textures
                g.drawImage(Images.testEndPoint,  x,  y,  width,  height,  null);
                break;
            case 1:
                g.drawImage(Images.testGrass,  x,  y,  width,  height,  null);
                break;
            case 2:
                g.drawImage(Images.testWall,  x,  y,  width,  height,  null);
                break;
            case 3:
                g.drawImage(Images.testWall,  x,  y,  width,  height,  null);
                break;
            default:
                break;
        }

    }
}
