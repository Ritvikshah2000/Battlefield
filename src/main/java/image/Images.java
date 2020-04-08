package image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {
    private static BufferedImage Enemy;
    private static BufferedImage Enemy2;
    private static BufferedImage Enemy3;
    private static BufferedImage Player;
    private static BufferedImage HealthBomb;
    private static BufferedImage ScoreBomb;
    private static BufferedImage Freeze;
    private static BufferedImage Grass;
    private static BufferedImage Wall;
    private static BufferedImage EndPoint;
    private static BufferedImage Hearts;
    private static BufferedImage Keys;
    private static BufferedImage EnemyFrozen;


    private Images() {
        try {
            Wall = ImageIO.read(getClass().getResource("/image/wall1.png"));
            Grass = ImageIO.read(getClass().getResource("/image/grass.png"));
            Player = ImageIO.read(getClass().getResource("/image/player.png"));
            Enemy = ImageIO.read(getClass().getResource("/image/enemy 1.png"));
            Enemy2 = ImageIO.read(getClass().getResource("/image/enemy 2.png"));
            Enemy3 = ImageIO.read(getClass().getResource("/image/enemy 3.png"));
            HealthBomb = ImageIO.read(getClass().getResource("/image/heartbomb.png"));
            ScoreBomb = ImageIO.read(getClass().getResource("/image/scorebomb.png"));
            Freeze = ImageIO.read(getClass().getResource("/image/freeze power.png"));
            EndPoint = ImageIO.read(getClass().getResource("/image/exit cell.png"));
            Hearts = ImageIO.read(getClass().getResource("/image/heart.png"));
            Keys = ImageIO.read(getClass().getResource("/image/key.png"));
            EnemyFrozen = ImageIO.read(getClass().getResource("/image/freeze_enemy.png"));
            Wall = ImageIO.read(getClass().getResource("/image/wall1.png"));
            Grass = ImageIO.read(getClass().getResource("/image/grass.png"));
            Player = ImageIO.read(getClass().getResource("/image/player.png"));
            Enemy = ImageIO.read(getClass().getResource("/image/enemy 1.png"));
            Enemy2 = ImageIO.read(getClass().getResource("/image/enemy 2.png"));
            Enemy3 = ImageIO.read(getClass().getResource("/image/enemy 3.png"));
            HealthBomb = ImageIO.read(getClass().getResource("/image/Health Hazard.png"));
            ScoreBomb = ImageIO.read(getClass().getResource("/image/blackbomb.png"));
            Freeze = ImageIO.read(getClass().getResource("/image/freeze power.png"));
            EndPoint = ImageIO.read(getClass().getResource("/image/exit cell.png"));
            Hearts = ImageIO.read(getClass().getResource("/image/heart.png"));
            Keys = ImageIO.read(getClass().getResource("/image/key.png"));
            EnemyFrozen = ImageIO.read(getClass().getResource("/image/freeze_enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadImages(){
       new Images();
    }


    public static BufferedImage getEnemyImage() { return Enemy; }
    public static BufferedImage getEnemy2Image() { return Enemy2; }
    public static BufferedImage getEnemy3Image() { return Enemy3; }
    public static BufferedImage getPlayerImage() { return Player; }
    public static BufferedImage getHealthBombImage() { return HealthBomb; }
    public static BufferedImage getScoreBombImage() { return ScoreBomb; }
    public static BufferedImage getFreezeImage() { return Freeze; }
    public static BufferedImage getGrassImage() { return Grass; }
    public static BufferedImage getWallImage() { return Wall; }
    public static BufferedImage getEndPointImage() { return EndPoint; }
    public static BufferedImage getHeartsImage() { return Hearts; }
    public static BufferedImage getKeysImage() { return Keys; }
    public static BufferedImage getEnemyFrozenImage() { return EnemyFrozen; }

}
