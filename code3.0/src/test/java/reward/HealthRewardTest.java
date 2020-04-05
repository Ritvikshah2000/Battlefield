package reward;

import actor.Health;
import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;

public class HealthRewardTest {
    @Test
    public void testHealthRewardConstructor(){ //checks that ScoreBomb placement works as intended
        HealthReward hr = new HealthReward(32,32);
        Assert.assertEquals(1024,(int)hr.x);
        Assert.assertEquals(1024, (int)hr.y);
    }

    @Test
    public void onHit() { //ensures that collision with a healthReward increases player's health
        Player player = new Player(15*32,4*32);
        HealthReward hr = new HealthReward(15*32,4*32);
        TestLevel testLevel = new TestLevel(1);
        Health health = new Health();
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        health.update(null);
        Assert.assertEquals(0,player.getScore());
        Assert.assertEquals(3, health.getHeartsLeft());
        player.collideContent(dx, dy);
        health.update(null);
        Assert.assertEquals(4, health.getHeartsLeft());
        Assert.assertEquals(50,player.getScore());
    }

    @Test
    public void update() {
    }
}

