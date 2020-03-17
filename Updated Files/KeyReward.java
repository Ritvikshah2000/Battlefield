package main;

import java.awt.Graphics2D;

public class KeyReward extends Reward {

	public KeyReward(int x, int y) {
		super(x *32, y *32);
		}

	@Override
	public void onHit() {
		Player.keyCounter++;
	}

	@Override
	public void update(Graphics2D g) {
		g.drawImage(Images.keyReward,x,y, 32, 32, null);
	}
}
