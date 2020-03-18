package main;
import java.awt.Graphics2D;

public class ScoreBomb extends Bomb{

	public final int scoreDamage = 200;

	ScoreBomb(int x, int y) {
		super(x * 32, y * 32);
	}

	@Override
	public void onHit() {
		Player.score -= scoreDamage;
		Score.update();
		TestLevel.addGrass(getX(), getY());
		Main.bombs.remove(this);
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(Images.testScoreBomb, x,y,32,32,null);
	}

}
