package hazard;

import actor.Health;
import actor.Player;
import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HealthBombTest {
    @Test
    public void testHealthBombConstructor(){ //checks that placement of healthbomb works properly
        HealthBomb hb = new HealthBomb(32,32);
        Assert.assertEquals(1024,(int)hb.x);
        Assert.assertEquals(1024, (int)hb.y);
    }

    @Test
    public void onHit() {
        HealthBomb hb = new HealthBomb(8*32,10*32); //create healthbomb object and place it on the map
        TestLevel tl = new TestLevel(1);
        Health h = new Health();

        Player player = new Player(8*32,10*32);
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];


        player.collideContent(dx,dy);
        h.update(null);
        Assert.assertEquals(2,h.heartsLeft);


    }

    @Test
    public void update() {
    }
}