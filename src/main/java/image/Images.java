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
            testWall = ImageIO.read(getClass().getResource("/image/wall1.png"));
            testGrass = ImageIO.read(getClass().getResource("/image/grass.png"));
            testPlayer = ImageIO.read(getClass().getResource("/image/player.png"));
            testEnemy = ImageIO.read(getClass().getResource("/image/enemy 1.png"));
            testEnemy2 = ImageIO.read(getClass().getResource("/image/enemy 2.png"));
            testEnemy3 = ImageIO.read(getClass().getResource("/image/enemy 3.png"));
            testHealthBomb = ImageIO.read(getClass().getResource("/image/heartbomb.png"));
            testScoreBomb = ImageIO.read(getClass().getResource("/image/scorebomb.png"));
            testFreeze = ImageIO.read(getClass().getResource("/image/freeze power.png"));
            testEndPoint = ImageIO.read(getClass().getResource("/image/exit cell.png"));
            testHearts = ImageIO.read(getClass().getResource("/image/heart.png"));
            testKeys = ImageIO.read(getClass().getResource("/image/key.png"));
            testEnemyFrozen = ImageIO.read(getClass().getResource("/image/freeze_enemy.png"));
            testWall = ImageIO.read(getClass().getResource("/image/wall1.png"));
            testGrass = ImageIO.read(getClass().getResource("/image/grass.png"));
            testPlayer = ImageIO.read(getClass().getResource("/image/player.png"));
            testEnemy = ImageIO.read(getClass().getResource("/image/enemy 1.png"));
            testEnemy2 = ImageIO.read(getClass().getResource("/image/enemy 2.png"));
            testEnemy3 = ImageIO.read(getClass().getResource("/image/enemy 3.png"));
            testHealthBomb = ImageIO.read(getClass().getResource("/image/Health Hazard.png"));
            testScoreBomb = ImageIO.read(getClass().getResource("/image/blackbomb.png"));
            testFreeze = ImageIO.read(getClass().getResource("/image/freeze power.png"));
            testEndPoint = ImageIO.read(getClass().getResource("/image/exit cell.png"));
            testHearts = ImageIO.read(getClass().getResource("/image/heart.png"));
            testKeys = ImageIO.read(getClass().getResource("/image/key.png"));
            testEnemyFrozen = ImageIO.read(getClass().getResource("/image/freeze_enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
