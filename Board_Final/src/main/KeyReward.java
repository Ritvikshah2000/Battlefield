<<<<<<< HEAD
package main;
=======

>>>>>>> 9e71ed87c99fe336f79dcf3d235c1347eec2d5aa
import java.awt.Graphics2D;

public class KeyReward extends Reward {

	public KeyReward(int x, int y) {
		super(x *32, y *32);
		value = 100;
		}

	@Override
	public void onHit() {
		Player.keyCount++;
		Player.score += value;
		Score.update();
		TestLevel.addGrass(getX(), getY());
		Main.rewards.remove(this);
		KeyBar.kBar.add(new KeyReward(15 + KeyBar.collected++, 0));
	}

	@Override
	public void update(Graphics2D g) {
		g.drawImage(Images.testKeys,x,y, 32, 32, null);
	}
}
