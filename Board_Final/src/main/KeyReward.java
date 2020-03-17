
import java.awt.Graphics2D;

public class KeyReward extends Reward {

	public KeyReward(int x, int y) {
		super(x *32, y *32);
		}

	@Override
	public void onHit() {
		Player.keyCount++;
		TestLevel.addGrass(getX(), getY());
		Main.rewards.remove(this);
		KeyBar.kBar.add(new KeyReward( 20 + KeyBar.collected++, 0));
	}

	@Override
	public void update(Graphics2D g) {
		g.drawImage(Images.testKeys,x,y, 32, 32, null);
	}
}
