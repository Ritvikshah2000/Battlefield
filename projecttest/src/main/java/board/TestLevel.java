package board;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class TestLevel {

    public static Tile[][] tiles = new Tile[Tile.GRIDSIZE][Tile.GRIDSIZE]; //grid

    public TestLevel()
    {
        for(int x = 0; x < tiles.length; x++)
            for(int y = 0; y < tiles[0].length;y++)
            {
                if(x == 0 || x == 59)
                {
                    tiles[x][y] = new Tile(3, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), true);
                }
                else if(y == 0 || y == 59)
                {
                    tiles[x][y] = new Tile(2, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), true);
                }
                else if((x == 15 && y == 15) || (x == 16 && y == 15 )||( x == 15 && y == 16) || (x == 16 && y == 16))
                {
                    tiles[x][y] = new Tile(3, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), true);
                }
                else
                {
                    tiles[x][y] = new Tile(1, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), false);
                } //first argument is the id of case
            }
    }

    public void update(Graphics2D g) {
        for(int x = 0; x < tiles.length; x++) for(int y = 0; y < tiles[0].length;y++) {
            tiles[x][y].update(g);
        }
    }

}
