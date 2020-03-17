//package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage tilesheet;
	public static BufferedImage testEnemy;
	public static BufferedImage testEnemy2;
	public static BufferedImage testEnemy3;
	public static BufferedImage testPlayer;
	public static BufferedImage testBomb;
	public static BufferedImage testBomb2;
	public static BufferedImage testFreeze;
	public static BufferedImage testGrass;
	public static BufferedImage testWall;
	public static BufferedImage testEndPoint;
	public static BufferedImage testHearts;
	public static BufferedImage[] tiles = new BufferedImage[4]; //based on how many tiles you have
	public static final int COL = 6;
	public static final int ROW = 5;


	public Images() {
		try {
			tilesheet = ImageIO.read(getClass().getResource("/bomb_party_v3.png"));

			tiles[0] = fromSpriteSheet(tilesheet,2,1); //col, row
			tiles[1] = fromSpriteSheet(tilesheet,6,5);
			tiles[2] = fromSpriteSheet(tilesheet,7,2);
			tiles[3] = fromSpriteSheet(tilesheet,7,4);
			testWall = ImageIO.read(getClass().getResource("/resources/wall1.png"));
			testGrass = ImageIO.read(getClass().getResource("/resources/grass.png"));
			testPlayer = ImageIO.read(getClass().getResource("/resources/player.png"));
			testEnemy = ImageIO.read(getClass().getResource("/resources/enemy 1.png"));
			testEnemy2 = ImageIO.read(getClass().getResource("/resources/enemy 2.png"));
			testEnemy3 = ImageIO.read(getClass().getResource("/resources/enemy 3.png"));
			testBomb = ImageIO.read(getClass().getResource("/resources/healthhazard.png"));
			testBomb2 = ImageIO.read(getClass().getResource("/resources/score hazard.png"));
			testFreeze = ImageIO.read(getClass().getResource("/resources/freeze power.png"));
			testEndPoint = ImageIO.read(getClass().getResource("/resources/exit cell.png"));
			testHearts = ImageIO.read(getClass().getResource("/resources/heart.png"));
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
