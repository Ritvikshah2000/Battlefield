package board;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage tilesheet, tilesheet2;	
	public static BufferedImage testplayer;
	public static BufferedImage[] tiles = new BufferedImage[4]; //based on how many tiles you have
	
	public Images() {
		try {
			tilesheet = ImageIO.read(getClass().getResource("/reso.png"));
			tilesheet2 = ImageIO.read(getClass().getResource("/player.png"));
			tiles[0] = fromSpriteSheet(tilesheet,1,2); //row, column
			tiles[1] = fromSpriteSheet(tilesheet,1,3); 
			//tiles[2] = fromSpriteSheet(tilesheet,1,4); 
			//tiles[3] = fromSpriteSheet(tilesheet,1,5); 
		    testplayer =fromSpriteSheet(tilesheet2,1,1); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage fromSpriteSheet(BufferedImage img, int column, int row) {
		BufferedImage newImage = img.getSubimage(row * Tile.TILESIZE - Tile.TILESIZE, column * Tile.TILESIZE - Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE); //gets a portion of spritesheet
		return newImage;
	}
}