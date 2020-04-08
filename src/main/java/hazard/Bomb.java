package hazard;

import board.Tile;
import java.awt.Graphics2D;

public abstract class Bomb {

    private int x;
    private int y;

    Bomb(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns this Bombs first index in the TestLevel.Tiles[][] array
     * @return this Bombs first index in the TestLevel.Tiles[][] array
     */
    public final int getX(){ return x / Tile.TILESIZE; }

    /**
     * Returns this Bombs second index in the TestLevel.Tiles[][] array
     * @return this Bombs second index in the TestLevel.Tiles[][] array
     */
    public final int getY(){ return y / Tile.TILESIZE; }

    /**
     * Defines action to take upon collision with Player
     */
    public abstract void onHit();

    /**
     * Redraws this Bombs Graphics
     * @param g Graphics2D instance used for redrawing
     */
    public abstract void update(final Graphics2D g);

}
