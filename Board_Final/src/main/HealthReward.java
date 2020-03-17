
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class HealthReward extends Reward {

	public HealthReward(int x, int y) {
		super(x*32, y*32);
	}

	public int getX(){ return (int)(x / 32); };
	public int getY(){ return (int)(y / 32); };

	@Override
	public void onHit() {
		Health.hp = Health.hp + 30;
		Health.bar.add(new HealthBar(32 * Health.heartsLeft, 0));
		TestLevel.addGrass(getX(), getY());
		Main.rewards.remove(this);
	}

	@Override
	public void update(Graphics2D g) {
		g.drawImage(Images.testHearts,x,y, 32, 32, null);
	}

}
