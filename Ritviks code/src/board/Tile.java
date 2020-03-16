package board;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


// 
public class Tile extends Rectangle {
	
	public int id;
	
	public static final int TILESIZE = 32; //becasue every image in the spritesheet is 16x16
	//Main m;
	public Tile(int id, Rectangle boundaries) {
		setBounds(boundaries);
		this.id = id;
	}
	//the switch case is in order to have separate levels, but we can adjust it to our needs
	public void update(Graphics2D g) {
		switch(id) {
		case -1: //without any textures
			g.setColor(new Color(243,184,122));
			g.fillRect(x, y, width, height);
			break;
		case 0: //base textures
			g.drawImage(Images.tilesheet,  x,  y,  width,  height,  null);
			break;
		case 1:
			g.drawImage(Images.tiles[0],  x,  y,  16,  16,  null);
			break;
		case 2:
			g.drawImage(Images.tiles[1],  x,  y,  width,  height,  null);
			break;
		case 3:
			g.drawImage(Images.tiles[2],  x,  y,  width,  height,  null);
			break;
		default:
			break;
		}
		
		}
	
}
