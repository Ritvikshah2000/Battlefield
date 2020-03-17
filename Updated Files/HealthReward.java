package main;

import java.awt.Graphics2D;

public class HealthReward extends Reward {

	public HealthReward(int x, int y) {
		super(x*32, y*32);
	}

	@Override
	public void onHit() {
		Health.hp = Health.hp+100;
	}

	@Override
	public void update(Graphics2D g) {
		g.drawImage(Images.healthReward,x,y, 32, 32, null);
	}

}
