package reward;

import actor.Health;
import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeyRewardTest {

    @Test
    public void testKeyRewardConstructor(){ //checks that ScoreBomb placement works as intended
        KeyReward kr = new KeyReward(32,32);
        Assert.assertEquals(1024,(int)kr.x);
        Assert.assertEquals(1024, (int)kr.y);
    }

    @Test
    public void onHit() { //ensures that colliding with a key increases score and keycount
        Player player = new Player(3*32,4*32);
        TestLevel testLevel = new TestLevel(1);
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];


        Assert.assertEquals(0,player.getScore());
        Assert.assertEquals(0, player.getKeyCount());
        player.collideContent(dx, dy);
        Assert.assertEquals(100,player.getScore());
        Assert.assertEquals(1, player.getKeyCount());
    }
}

