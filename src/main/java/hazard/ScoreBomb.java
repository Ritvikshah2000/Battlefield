package hazard;

import actor.Player;
import actor.Score;
import board.TestLevel;
import image.Images;
import music.Boom;
import playgame.Main;
import java.awt.Graphics2D;

public class ScoreBomb extends Bomb{

    public final int scoreDamage = 200;
    public Boom boom;

    public ScoreBomb(int x, int y) {
        super(x * 32, y * 32);
    }

    public void onHit() {
        this.boom = new Boom();
        Player.setScore(-scoreDamage);
        Score.update();
        TestLevel.addGrass(getX(), getY());
        Main.getBomb().remove(this);
    }

    public void update(Graphics2D g) {
        g.drawImage(Images.getScoreBombImage(), x,y,32,32,null);
    }

}