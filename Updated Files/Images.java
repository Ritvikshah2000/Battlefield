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
	/*public static BufferedImage testBomb2;
	public static BufferedImage testBomb3;
	public static BufferedImage testBomb4;*/
	

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
			testPlayer = fromSpriteSheet(tilesheet,4,5);
			testEnemy = fromSpriteSheet(tilesheet,4,4);
			testBomb = fromSpriteSheet(tilesheet, 5,3);
			testBomb2 = ImageIO.read(getClass().getResource("/healthhazard.png"));
		/*	testBomb2 = fromSpriteSheet(tilesheet, 8,6);    // IGNORE!!
			testBomb3 = fromSpriteSheet(tilesheet, 5,4);
			testBomb4 = fromSpriteSheet(tilesheet, 5,5);*/

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage fromSpriteSheet(BufferedImage img, int column, int row) {
		img = img.getSubimage(column * 16 - 16, row * 16 - 16, 16, 16); //gets a portion of spritesheet
		//img = img.getSubimage(COL, ROW, Tile.TILESIZE, Tile.TILESIZE); //gets a portion of spritesheet
		return img;
	}
}
