package image;

import board.Tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
    public static BufferedImage tilesheet;
    public static BufferedImage testEnemy;
    public static BufferedImage testPlayer;
    public static BufferedImage testFreeze;
    public static BufferedImage[] tiles = new BufferedImage[4]; //based on how many tiles you have
    public static final int COL = 6;
    public static final int ROW = 5;


    public Images()
    {
        try
        {
            tilesheet = ImageIO.read(getClass().getResource("/bomb_party_v3.png"));

            tiles[0] = fromSpriteSheet(tilesheet,2,1); // grass
            tiles[1] = fromSpriteSheet(tilesheet,6,5); // horiz barrier
            tiles[2] = fromSpriteSheet(tilesheet,7,2); // verti barrier
            tiles[3] = fromSpriteSheet(tilesheet,7,4); // ball
            testPlayer = fromSpriteSheet(tilesheet,4,5); // main character
            testEnemy = fromSpriteSheet(tilesheet,4,2); // enemy

            testFreeze = ImageIO.read(getClass().getResource("/freeze.png"));
            //testFreeze = tiles[3];
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public BufferedImage fromSpriteSheet(BufferedImage img, int column, int row)
    {
        img = img.getSubimage(column * Tile.TILESIZE - Tile.TILESIZE, row * Tile.TILESIZE - Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE); //gets a portion of spritesheet
        //img = img.getSubimage(COL, ROW, Tile.TILESIZE, Tile.TILESIZE); //gets a portion of spritesheet
        return img;
    }
}
