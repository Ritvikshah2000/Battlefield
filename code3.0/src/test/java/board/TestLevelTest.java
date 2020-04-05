package board;

import hazard.HealthBomb;
import hazard.ScoreBomb;
import org.junit.Assert;
import playgame.Main;
import reward.Freeze;
import reward.HealthReward;
import reward.KeyReward;
import org.junit.Test;

public class TestLevelTest {

    @Test
    public void addGrass(){
        TestLevel test = new TestLevel(1);
        TestLevel.addGrass(1,1);

        Assert.assertFalse(TestLevel.tiles[1][1].hasContents());
        Assert.assertNull(TestLevel.tiles[1][1].getContents());
        Assert.assertFalse(TestLevel.tiles[1][1].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[1][1].id);

    }

    @Test
    public void addBombs(){
        TestLevel test = new TestLevel(1);
        HealthBomb hb = new HealthBomb(1, 1);
        ScoreBomb sb = new ScoreBomb(16, 4);
        test.addBomb(1,1, hb);
        test.addBomb(16,4, sb);

        Assert.assertTrue(TestLevel.tiles[1][1].hasContents());
        Assert.assertEquals(hb,TestLevel.tiles[1][1].getContents());
        Assert.assertFalse(TestLevel.tiles[1][1].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[1][1].id);

        Assert.assertTrue(TestLevel.tiles[16][4].hasContents());
        Assert.assertEquals(sb, TestLevel.tiles[16][4].getContents());
        Assert.assertFalse(TestLevel.tiles[16][4].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[16][4].id);

        Assert.assertTrue(Main.getBomb().contains(hb));
        Assert.assertTrue(Main.getBomb().contains(sb));
    }

    @Test
    public void addRewards(){
        TestLevel test = new TestLevel(1);
        KeyReward key = new KeyReward(1, 1);
        Freeze fz = new Freeze(1,1);
        HealthReward hp = new HealthReward(1,1);
        test.addReward(1,1, key);
        test.addReward(3,4, fz);
        test.addReward(5,10, hp);

        Assert.assertTrue(TestLevel.tiles[1][1].hasContents());
        Assert.assertEquals(key,TestLevel.tiles[1][1].getContents());
        Assert.assertFalse(TestLevel.tiles[1][1].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[1][1].id);

        Assert.assertTrue(TestLevel.tiles[3][4].hasContents());
        Assert.assertEquals(fz, TestLevel.tiles[3][4].getContents());
        Assert.assertFalse(TestLevel.tiles[3][4].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[3][4].id);

        Assert.assertTrue(TestLevel.tiles[5][10].hasContents());
        Assert.assertEquals(hp, TestLevel.tiles[5][10].getContents());
        Assert.assertFalse(TestLevel.tiles[5][10].barrier);
        Assert.assertEquals( 1, TestLevel.tiles[5][10].id);


        Assert.assertTrue(Main.getRewards().contains(key));
        Assert.assertTrue(Main.getRewards().contains(fz));
        Assert.assertTrue(Main.getRewards().contains(hp));
    }

    @Test
    public void setEndPoint(){
        TestLevel test = new TestLevel(1);
        EndPoint end = new EndPoint();
        test.setEndPoint(1,1, end);

        Assert.assertTrue(TestLevel.tiles[1][1].hasContents());
        Assert.assertEquals(end,TestLevel.tiles[1][1].getContents());
        Assert.assertFalse(TestLevel.tiles[1][1].barrier);
        Assert.assertEquals( 0, TestLevel.tiles[1][1].id);
    }


}
