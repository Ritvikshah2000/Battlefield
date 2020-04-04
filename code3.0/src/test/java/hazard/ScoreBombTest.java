package hazard;

import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;


public class ScoreBombTest {
    @Test
    public void testScoreBombConstructor(){ //checks that ScoreBomb placement works as intended
        ScoreBomb sb = new ScoreBomb(32,32);
        Assert.assertEquals(1024,(int)sb.x);
        Assert.assertEquals(1024, (int)sb.y);
    }


    @Test
    public void onHit() { //checks that Player and scorebomb are in the same tile
        ScoreBomb sb = new ScoreBomb(11*32,3*32);
        TestLevel tl = new TestLevel(1);

        Player player = new Player(11*32,3*32);
        int[]currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        Assert.assertEquals(0,player.getScore());
        player.collideContent(dx,dy);
        Assert.assertEquals(-200,player.getScore());
    }

    @Test
    public void update() {
    }
}

