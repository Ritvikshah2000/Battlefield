package hazard;

import actor.Health;
import board.TestLevel;
import image.Images;
import music.Boom;
import playgame.Main;
import java.awt.Graphics2D;

public class HealthBomb extends Bomb {

    public HealthBomb(int x, int y) {
        super(x * 32, y * 32);
    }


    /**
     * Decreases Players health count and removes this Bomb
     */
    @Override
    public void onHit() {
        Boom boom = new Boom();
        Health.getBar().remove(Health.getIndex());//health minus
        Health.decreaseHeartLeft();
        TestLevel.addGrass(getX(), getY());
        Main.getBomb().remove(this);
    }

    /**
     * Redraws this HealthBombs Graphics
     * @param g Graphics2D instance used for redrawing
     */
    @Override
    public void update(Graphics2D g){
        g.drawImage(Images.getHealthBombImage(), getX(), getY(), 32, 32, null);
    }

}