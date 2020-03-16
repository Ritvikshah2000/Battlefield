package main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage tilesheet;
	
	public static BufferedImage[] tiles = new BufferedImage[4]; //based on how many tiles you have

	
	public Images() {
		try {
			tilesheet = ImageIO.read(getClass().getResource("/bomb_party_v3.png"));
			
			tiles[0] = fromSpriteSheet(tilesheet,2,1); //col, row
			tiles[1] = fromSpriteSheet(tilesheet,1,1); 
			tiles[2] = fromSpriteSheet(tilesheet,4,1); 
			tiles[3] = fromSpriteSheet(tilesheet,5,1); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage fromSpriteSheet(BufferedImage img, int column, int row) {
		img = img.getSubimage(column * Tile.TILESIZE - Tile.TILESIZE, row * Tile.TILESIZE - Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE); //gets a portion of spritesheet
		return img;
	}
}
