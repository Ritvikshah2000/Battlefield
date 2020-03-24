package reward;

import actor.Health;
import actor.HealthBar;
import actor.Player;
import actor.Score;
import board.TestLevel;
import image.Images;
import playgame.Main;

import java.awt.*;


public class HealthReward extends Reward {


    public HealthReward(int x, int y) {
        super(x*32, y*32);
        value = 50;
    }


    public void onHit() {
        Health.hp = (Health.heartsLeft + 1) * 30;
        Health.bar.add(new HealthBar((32 * Health.heartsLeft), 0));
        Player.score += value;
        Score.update();
        TestLevel.addGrass(getX(), getY());
        Main.rewards.remove(this);
    }

    public void update(Graphics2D g) {
        g.drawImage(Images.testHearts, x, y, 32, 32, null);
    }

}
