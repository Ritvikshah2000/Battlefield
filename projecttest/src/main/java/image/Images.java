package image;

import board.Tile;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {
    public static BufferedImage tilesheet;
    public static BufferedImage testEnemy;
    public static BufferedImage testEnemy2;
    public static BufferedImage testEnemy3;
    public static BufferedImage testPlayer;
    public static BufferedImage testHealthBomb;
    public static BufferedImage testScoreBomb;
    public static BufferedImage testFreeze;
    public static BufferedImage testGrass;
    public static BufferedImage testWall;
    public static BufferedImage testEndPoint;
    public static BufferedImage testHearts;
    public static BufferedImage testKeys;
    public static BufferedImage testEnemyFrozen;
    public static BufferedImage[] tiles = new BufferedImage[4]; //based on how many tiles you have
    public static final int COL = 6;
    public static final int ROW = 5;


    public Images() {
        try {
            testWall = ImageIO.read(getClass().getResource("/wall1.png"));
            testGrass = ImageIO.read(getClass().getResource("/grass.png"));
            testPlayer = ImageIO.read(getClass().getResource("/player.png"));
            testEnemy = ImageIO.read(getClass().getResource("/enemy 1.png"));
            testEnemy2 = ImageIO.read(getClass().getResource("/enemy 2.png"));
            testEnemy3 = ImageIO.read(getClass().getResource("/enemy 3.png"));
            ImageIO.read(getClass().getResource("/healthhazard.png"));
            testScoreBomb = ImageIO.read(getClass().getResource("/score hazard.png"));
            testFreeze = ImageIO.read(getClass().getResource("/freeze power.png"));
            testEndPoint = ImageIO.read(getClass().getResource("/exit cell.png"));
            testHearts = ImageIO.read(getClass().getResource("/heart.png"));
            testKeys = ImageIO.read(getClass().getResource("/key.png"));
            testEnemyFrozen = ImageIO.read(getClass().getResource("/freeze_enemy.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public BufferedImage fromSpriteSheet(BufferedImage img, int column, int row) {
        img = img.getSubimage(column * (Tile.TILESIZE/2) - (Tile.TILESIZE/2), row * (Tile.TILESIZE/2) - (Tile.TILESIZE/2), Tile.TILESIZE/2, Tile.TILESIZE/2); //gets a portion of spritesheet
        //img = img.getSubimage(column, row, Tile.TILESIZE/2, Tile.TILESIZE/2); //gets a portion of spritesheet
        return img;
    }
}



