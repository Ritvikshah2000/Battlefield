package board;

import image.Images;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public final class Tile<T> extends Rectangle {

    private int id;
    private boolean barrier;
    private T item;
    private int x;
    private int y;
    private int height;
    private int width;


    public static final int GRIDSIZE = 20; //contains 20 tiles
    public static final int TILESIZE = 32;

    public Tile(final int id, final Rectangle boundaries, final boolean barrier, final T contents) {
        this.setBounds(boundaries);
        x = boundaries.x;
        y = boundaries.y;
        height = boundaries.height;
        width = boundaries.width;
        this.id = id;
        this.barrier = barrier;
        item = contents;
    }

    public int getTileX() { return x; }
    public int getTileY() { return y; }
    public int getTileHeight() { return height; }
    public int getTileWidth() { return width; }
    public int getId(){ return id; }
    public boolean isBarrier(){ return barrier; }
    public T getItem() {return item; }

    public Rectangle getBounds() {
        return super.getBounds();
    }

    public boolean hasContents(){ return item != null; }

    public T getContents(){
        return item;
    }


    public void update(final Graphics2D g) {
        final int RED = 243;
        final int GREEN = 184;
        final int BLUE = 122;
        switch(id) {
            case 0: // endpoint
                g.drawImage(Images.getEndPointImage(),  x,  y,  width,  height,  null);
                break;
            case 1: //
                g.drawImage(Images.getGrassImage(),  x,  y,  width,  height,  null);
                break;
            case 2:
                g.drawImage(Images.getWallImage(),  x,  y,  width,  height,  null);
                break;
            default: //without any textures
                g.setColor(new Color(RED, GREEN, BLUE));
                g.fillRect(x, y, width, height);
                break;
        }

    }
}
