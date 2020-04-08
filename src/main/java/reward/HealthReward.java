package reward;

import actor.Health;
import actor.HealthBar;
import actor.Player;
import actor.Score;
import board.TestLevel;
import board.Tile;
import image.Images;
import playgame.Main;
import java.awt.Graphics2D;


public final class HealthReward extends Reward {


    public HealthReward(final int x, final int y) {
        super(x * Tile.TILESIZE, y * Tile.TILESIZE);
        value = 50;
    }


    public void onHit() {
        Health.increaseHp((Health.getHeartsLeft() + 1) * Health.getHeartHpThreshold());
        Health.getBar().add(new HealthBar((Tile.TILESIZE * Health.getHeartsLeft()), 0));
        Player.setScore(value);
        Score.update();
        TestLevel.addGrass(getXIndex(), getYIndex());
        Main.getRewards().remove(this);
    }

    public void update(final Graphics2D g) {
        g.drawImage(Images.getHeartsImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE, null);
    }

}
