package image;

import board.Tile;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {
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


    public Images() {
        try {
            testWall = ImageIO.read(getClass().getResource("/wall1.png"));
            testGrass = ImageIO.read(getClass().getResource("/grass.png"));
            testPlayer = ImageIO.read(getClass().getResource("/player.png"));
            testEnemy = ImageIO.read(getClass().getResource("/enemy 1.png"));
            testEnemy2 = ImageIO.read(getClass().getResource("/enemy 2.png"));
            testEnemy3 = ImageIO.read(getClass().getResource("/enemy 3.png"));
            testHealthBomb = ImageIO.read(getClass().getResource("/heartbomb.png"));
            testScoreBomb = ImageIO.read(getClass().getResource("/scorebomb.png"));
            testFreeze = ImageIO.read(getClass().getResource("/freeze power.png"));
            testEndPoint = ImageIO.read(getClass().getResource("/exit cell.png"));
            testHearts = ImageIO.read(getClass().getResource("/heart.png"));
            testKeys = ImageIO.read(getClass().getResource("/key.png"));
            testEnemyFrozen = ImageIO.read(getClass().getResource("/freeze_enemy.png"));
            testWall = ImageIO.read(getClass().getResource("/wall1.png"));
            testGrass = ImageIO.read(getClass().getResource("/grass.png"));
            testPlayer = ImageIO.read(getClass().getResource("/player.png"));
            testEnemy = ImageIO.read(getClass().getResource("/enemy 1.png"));
            testEnemy2 = ImageIO.read(getClass().getResource("/enemy 2.png"));
            testEnemy3 = ImageIO.read(getClass().getResource("/enemy 3.png"));
            testHealthBomb = ImageIO.read(getClass().getResource("/Health Hazard.png"));
            testScoreBomb = ImageIO.read(getClass().getResource("/blackbomb.png"));
            testFreeze = ImageIO.read(getClass().getResource("/freeze power.png"));
            testEndPoint = ImageIO.read(getClass().getResource("/exit cell.png"));
            testHearts = ImageIO.read(getClass().getResource("/heart.png"));
            testKeys = ImageIO.read(getClass().getResource("/key.png"));
            testEnemyFrozen = ImageIO.read(getClass().getResource("/freeze_enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
