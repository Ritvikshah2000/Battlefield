package main;

import java.awt.Graphics2D;

public class ScoreBomb extends Bomb{

	public int healthDamage;
	
	ScoreBomb(int x, int y) {
		super(x, y);
	}

	@Override
	public void onHit(Graphics2D g) {
		//if collision then 
		//score = score - healthDamage
		//??SCORE CLASS
		
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(Images.testBomb2, x,y,32,32,null);
		onHit(g);
	}
	
	}


