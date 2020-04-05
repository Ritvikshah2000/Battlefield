package hazard;

import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;


public class ScoreBombTest {
    @Test
    public void testScoreBombConstructor(){ //checks that ScoreBomb placement works as intended
        ScoreBomb sb = new ScoreBomb(32,32);
        Assert.assertEquals(1024,(int)sb.x);
        Assert.assertEquals(1024, (int)sb.y);
    }


    @Test
    public void onHit() { //checks that Player and scorebomb are in the same tile
//        ScoreBomb sb = new ScoreBomb(11,3);
//        TestLevel tl = new TestLevel(1);
//
//        Player player = new Player(11*32,3*32);
//        int[]currentTile = player.currentTile();
//        int dx = currentTile[0];
//        int dy = currentTile[1];
//
//        Assert.assertEquals(0,player.getScore());
//        player.collideContent(dx,dy);
//        Assert.assertEquals(-200,player.getScore());
        ScoreBomb sb = new ScoreBomb(11,3);
        TestLevel tl = new TestLevel(1);
        tl.addBomb(11, 3, sb);
        Player miss = new Player(10*32, 3*32);
        int[]currentTile = miss.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];
        miss.collideContent(dx, dy);
        Assert.assertTrue(Main.getBomb().contains(sb));
        Assert.assertEquals(0, miss.getScore());

        Player hit = new Player(11*32, 3*32);
        currentTile = hit.currentTile();
        dx = currentTile[0];
        dy = currentTile[1];
        hit.collideContent(dx, dy);
        Assert.assertFalse(Main.getBomb().contains(sb));
        Assert.assertEquals(-200, hit.getScore());
    }

    @Test
    public void update() {
    }
}

