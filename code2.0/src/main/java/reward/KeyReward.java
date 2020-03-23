package reward;

import actor.KeyBar;
import actor.Player;
import actor.Score;
import board.TestLevel;
import image.Images;
import music.KeySound;
import playgame.Main;

import java.awt.Graphics2D;

public class KeyReward extends Reward {
    private KeySound keysound;

    public KeyReward(int x, int y) {
        super(x *32, y *32);
        value = 100;
    }

    public void onHit() {
        this.keysound = new KeySound();
        Player.keyCount++;
        Player.score += value;
        Score.update();
        TestLevel.addGrass(getX(), getY());
        Main.rewards.remove(this);
        KeyBar.kBar.add(new KeyReward(15 + KeyBar.collected++, 0));
    }

    public void update(Graphics2D g) {
        g.drawImage(Images.testKeys,x,y, 32, 32, null);
    }
}
