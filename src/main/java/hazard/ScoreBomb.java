package hazard;

import actor.Player;
import actor.Score;
import board.TestLevel;
import image.Images;
import music.Boom;
import playgame.Main;
import java.awt.Graphics2D;

public class ScoreBomb extends Bomb{

    private final int scoreDamage = 200;

    public ScoreBomb(int x, int y) {
        super(x * 32, y * 32);
    }

    /**
     * Decreases Players score upon collision, the nremoves this Bomb
     */
    @Override
    public void onHit() {
        Boom boom = new Boom();
        Player.setScore(-scoreDamage);
        Score.update();
        TestLevel.addGrass(getX(), getY());
        Main.getBomb().remove(this);
    }

    /**
     * Redraws this ScoreBombs graphics
     * @param g Graphics2D instance used for redrawing
     */
    @Override
    public void update(Graphics2D g) {
        g.drawImage(Images.getScoreBombImage(), getX(), getY(),32,32,null);
    }

}