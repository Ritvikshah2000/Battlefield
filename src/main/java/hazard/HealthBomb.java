package hazard;

import actor.Health;
import board.TestLevel;
import image.Images;
import music.Boom;
import playgame.Main;
import java.awt.Graphics2D;

public class HealthBomb extends Bomb {

    public Boom boom;

    public HealthBomb(int x, int y) {
        super(x * 32, y * 32);
    }


    @Override
    public void onHit() {
        this.boom = new Boom();
        Health.getBar().remove(Health.getIndex());//health minus
        Health.decreaseHeartLeft();
        TestLevel.addGrass(getX(), getY());
        Main.getBomb().remove(this);
    }

    @Override
    public void update(Graphics2D g){
        g.drawImage(Images.getHealthBombImage(), x, y, 32, 32, null);
    }

}