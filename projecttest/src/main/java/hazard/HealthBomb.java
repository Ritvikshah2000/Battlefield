package hazard;
import actor.Health;
import board.TestLevel;
import board.Tile;
import image.Images;
import playgame.Main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class HealthBomb extends Bomb {

    public int healthDamage = 10;

    public HealthBomb(int x, int y) {
        super(x * 32, y * 32);
    }


    @Override
    public void onHit() {
        Health.bar.remove(Health.index);//health minus
        TestLevel.addGrass(getX(), getY());
        Main.bombs.remove(this);
    }

    @Override
    public void update(Graphics2D g){
        g.drawImage(Images.testHealthBomb, x, y, 32, 32, null);
    }

}


