package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage tilesheet;
	public static BufferedImage testEnemy;
	public static BufferedImage testPlayer;
	public static BufferedImage testBomb;
	public static BufferedImage testBomb2;
	public static BufferedImage testFreeze, keyReward, healthReward;
	public static BufferedImage[] tiles = new BufferedImage[4]; //based on how many tiles you have
	public static final int COL = 6;
	public static final int ROW = 5;


	public Images() {
		try {
			tilesheet = ImageIO.read(getClass().getResource("/bomb_party_v3.png"));

			tiles[0] = fromSpriteSheet(tilesheet,2,1); //grass tile
			tiles[1] = fromSpriteSheet(tilesheet,6,5);//barrier tile
			tiles[2] = fromSpriteSheet(tilesheet,7,2);//barrier tile
			tiles[3] = fromSpriteSheet(tilesheet,7,4);
			testPlayer = ImageIO.read(getClass().getResource("/player.png"));
			testEnemy = ImageIO.read(getClass().getResource("/enemy 1.png"));
			testBomb = ImageIO.read(getClass().getResource("/healthhazard.png"));
			testBomb2 = ImageIO.read(getClass().getResource("/score hazard.png"));
			testFreeze = ImageIO.read(getClass().getResource("/freeze power.png"));
			healthReward = ImageIO.read(getClass().getResource("/heart.png"));
			keyReward = ImageIO.read(getClass().getResource("/key.png"));
			
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
