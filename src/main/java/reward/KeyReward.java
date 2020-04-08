package reward;

import actor.KeyBar;
import actor.Player;
import actor.Score;
import board.TestLevel;
import board.Tile;
import image.Images;
import music.KeySound;
import playgame.Main;

import java.awt.Graphics2D;

public final class KeyReward extends Reward {

    public KeyReward(final int x, final int y) {
        super(x * Tile.TILESIZE, y *Tile.TILESIZE);
        setValue(100);
    }

    public void onHit() {
        KeySound keysound = new KeySound();
        Player.IncreaseKeyCount();
        Player.setScore(getValue());
        Score.update();
        TestLevel.addGrass(getXIndex(), getYIndex());
        Main.getRewards().remove(this);
        KeyBar.getKbar().add(new KeyReward(KeyBar.getInitialTile() + KeyBar.increaseCollected(), 0));
    }

    public void update(final Graphics2D g) {
        g.drawImage(Images.getKeysImage(), getX(), getY(), Tile.TILESIZE, Tile.TILESIZE, null);
    }
}

