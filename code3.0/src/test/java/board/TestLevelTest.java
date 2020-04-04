package board;

import board.TestLevel;
import hazard.Bomb;
import hazard.HealthBomb;
import hazard.ScoreBomb;
import org.junit.Assert;
import playgame.Main;
import reward.Freeze;
import reward.HealthReward;
import reward.KeyReward;
import reward.Reward;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import org.junit.Test;

public class TestLevelTest {

    @Test
    public void testAddGrass(){
        TestLevel test = new TestLevel(1);
        TestLevel.addGrass(1,1);
        Assert.assertFalse(TestLevel.tiles[1][1].hasContents());
        Assert.assertFalse(TestLevel.tiles[1][1].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[1][1].id);

    }

    @Test
    public void testAddBomb(){
        TestLevel test = new TestLevel(1);
        HealthBomb hb = new HealthBomb(1, 1);
        test.addBomb(1,1, hb);
        Assert.assertTrue(TestLevel.tiles[1][1].hasContents());
        Assert.assertEquals(hb,TestLevel.tiles[1][1].getContents());
        Assert.assertFalse(TestLevel.tiles[1][1].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[1][1].id);

    }

    @Test
    public void testAddReward(){
        TestLevel test = new TestLevel(1);
        KeyReward key = new KeyReward(1, 1);
        test.addReward(1,1, key);
        Assert.assertTrue(TestLevel.tiles[1][1].hasContents());
        Assert.assertEquals(key,TestLevel.tiles[1][1].getContents());
        Assert.assertFalse(TestLevel.tiles[1][1].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[1][1].id);

    }

    @Test
    public void testSetEndPoint(){
        TestLevel test = new TestLevel(1);
        EndPoint end = new EndPoint();
        test.setEndPoint(1,1, end);
        Assert.assertTrue(TestLevel.tiles[1][1].hasContents());
        Assert.assertEquals(end,TestLevel.tiles[1][1].getContents());
        Assert.assertFalse(TestLevel.tiles[1][1].barrier);
        Assert.assertEquals( 0, TestLevel.tiles[1][1].id);

    }


}
