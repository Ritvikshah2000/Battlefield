package main;

import java.awt.Graphics2D;

public class HealthBomb extends Bomb {
	
	public int healthDamage = 10;
	
	HealthBomb(int x, int y) {
		super(x, y);
	}

	@Override
	public void onHit(Graphics2D g) {
		if((int)Player.x==this.x || (int) Player.y == this.y) { //???if player hits bomb(not sure about algorithm)	
			Health.hp = Health.hp-healthDamage;//health minus
		/*	g.drawImage(Images.testBomb3, x,y,32,32,null);   //IGNORE!!
			g.drawImage(Images.testBomb4, x,y,32,32,null);

			for(int i=0;i<1000;i++)
			g.drawImage(Images.testBomb2, x,y,32,32,null);
			g.drawImage(Images.tiles[0], x,y,32,32 ,null);*/		
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.drawImage(Images.testBomb, x,y,32,32,null);
		onHit(g);		 
	}

}
