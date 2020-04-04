package reward;

import actor.Player;
import board.TestLevel;
import hazard.ScoreBomb;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreezeTest {
    @Test
    public void testFreezeConstructor(){ //checks that ScoreBomb placement works as intended
        Freeze fr = new Freeze(32,32);
        Assert.assertEquals(1024,(int)fr.x);
        Assert.assertEquals(1024, (int)fr.y);
    }

    @Test
    public void onHit() { //checks whether collision with a freezeReward works properly
        Freeze fr = new Freeze(3*32,16*32);
        TestLevel tl = new TestLevel(1);

        Player player = new Player(3*32,16*32);
        int[]currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        Assert.assertEquals(0,player.getScore());
        player.collideContent(dx,dy);
        Assert.assertEquals(150,player.getScore());
    }

    @Test
    public void update() {
    }
}

