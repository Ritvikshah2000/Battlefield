package actor;

import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;

import java.awt.*;
import java.util.ArrayList;

public class PlayerTest {
    @Test
    public void testPlayerConstructor()
    {
        Player player = new Player(32,16);
        Assert.assertEquals(32,  (int)player.x);
        Assert.assertEquals(16,  (int)player.y);
        Assert.assertTrue(player.canLeft);
        Assert.assertTrue(player.canRight);
        Assert.assertTrue(player.canUp);
        Assert.assertTrue(player.canDown);
    }

    @Test
    public void testGetBounds()     // test getBounds return correct result.
    {
        Player player = new Player(1,2);
        Rectangle rectangle = player.getBounds();
        Assert.assertEquals(1,rectangle.x);
        Assert.assertEquals(2,rectangle.y);
        Assert.assertEquals(32,rectangle.width);
        Assert.assertEquals(32,rectangle.height);
    }

    /*--------------------------------------Collision()------------------------------------------*/

    @Test
    public void testCurrentTile()
    {
        Player player = new Player(32,64);
        int[] currentTile = player.currentTile();
        Assert.assertEquals(1, currentTile[0]);
        Assert.assertEquals(2, currentTile[1]);

        player.x = 47;
        player.y = 79;
        currentTile = player.currentTile();
        Assert.assertEquals(1, currentTile[0]);
        Assert.assertEquals(2, currentTile[1]);

        player.x = 48;
        player.y = 80;
        currentTile = player.currentTile();
        Assert.assertEquals(2, currentTile[0]);
        Assert.assertEquals(3, currentTile[1]);

        player.x = 49;
        player.y = 81;
        currentTile = player.currentTile();
        Assert.assertEquals(2, currentTile[0]);
        Assert.assertEquals(3, currentTile[1]);
    }

    /*@Test
    public void testCollideEnemy()
    {
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(new Enemy(32, 32));
        Player player = new Player(32,32);
        Health health = new Health();

        for(int i = 0; i < enemies.size(); i++)
            if(enemies.get(i).getBounds().intersects(player.getBounds())){
                if(health.hp % 30 == 0){    //have an hp value and only remove if the value drops to a certain amount
                    health.bar.remove(Health.index);
                    health.hp -= Enemy.damage;
                    health.heartsLeft--;    // heart bar index -1
                }else
                    health.hp -= Enemy.damage;
            }
        health.update(null);
        Assert.assertEquals(88, (int)health.hp);
        Assert.assertEquals(3, health.heartsLeft);
        Assert.assertEquals(2, health.index);

        for (int k = 0; k < 58; k++)
        {
            for(int i = 0; i < enemies.size(); i++)
                if(enemies.get(i).getBounds().intersects(player.getBounds())){
                    if(health.hp % 30 == 0){    //have an hp value and only remove if the value drops to a certain amount
                        health.bar.remove(Health.index);
                        health.hp -= Enemy.damage;
                        health.heartsLeft--;    // heart bar index -1
                    }else
                        health.hp -= Enemy.damage;
                }
            health.update(null);
        }
        Assert.assertEquals(59, (int)health.hp);
        Assert.assertEquals(2, health.heartsLeft);
        Assert.assertEquals(1, health.index);
    }*/

    /*@Test
    public void testCollideHealthBomb()
    {
        Player player = new Player(8*32,10*32);
        TestLevel testLevel = new TestLevel(1);
        Health health = new Health();
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        player.collideContent(dx, dy);
        health.update(null);
        Assert.assertEquals(2, health.heartsLeft);
    }

    @Test
    public void testCollideScoreBomb()
    {
        Player player = new Player(11*32,3*32);
        TestLevel testLevel = new TestLevel(1);
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        Assert.assertEquals(0, player.score);
        player.collideContent(dx, dy);
        Assert.assertEquals(-200, player.score);
    }

    @Test
    public void testCollideFreeze()
    {
        Player player = new Player(3*32,16*32);
        TestLevel testLevel = new TestLevel(1);
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        // now the score is -200
        Assert.assertEquals(0, player.score);
        player.collideContent(dx, dy);
        Assert.assertEquals(150, player.score);
    }

    @Test
    public void testCollideHealthReward()
    {
        Player player = new Player(15*32,4*32);
        TestLevel testLevel = new TestLevel(1);
        Health health = new Health();
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        health.update(null);
        Assert.assertEquals(3, health.heartsLeft);
        player.collideContent(dx, dy);
        health.update(null);
        Assert.assertEquals(4, health.heartsLeft);
    }

    @Test
    public void testCollideKeyReward()
    {
        Player player = new Player(3*32,4*32);
        TestLevel testLevel = new TestLevel(1);
        Health health = new Health();
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        Assert.assertEquals(0, player.keyCount);
        player.collideContent(dx, dy);
        Assert.assertEquals(1, player.keyCount);
    }

    @Test
    public void testCollideEndPointContinue()
    {
        Player player = new Player(18*32,18*32);
        TestLevel testLevel = new TestLevel(1);
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];
        Main.running = true;
        Assert.assertEquals(0, player.keyCount);
        Assert.assertTrue(Main.running);
    }

    @Test
    public void testCollideEndPointOver()
    {
        Player player = new Player(18*32,18*32);
        TestLevel testLevel = new TestLevel(1);
        int[] currentTile = player.currentTile();
        int dx = currentTile[0];
        int dy = currentTile[1];

        Assert.assertEquals(0, player.keyCount);
        player.keyCount += 5;
        Assert.assertFalse(Main.running);
    }*/

    @Test
    public void testCheckMoveCanLeft()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,32);
        Assert.assertTrue(player.canLeft);   // check initially canLeft is true
        player.checkMove();
        Assert.assertFalse(player.canLeft);  // in level there is barrier in the left hand side of enemy, canLeft become false

        Player player2 = new Player(64,32);
        Assert.assertTrue(player2.canLeft);  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(player2.canLeft);  // in level there is no barrier in the left hand side of enemy2, canLeft should be true
    }

    @Test
    public void testCheckMoveCanRight()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,64);
        Assert.assertTrue(player.canRight);
        player.collision();
        Assert.assertFalse(player.canRight);

        Player player2 = new Player(32,32);
        Assert.assertTrue(player2.canRight);
        player2.collision();
        Assert.assertTrue(player2.canRight);
    }

    @Test
    public void testCheckMoveCanUp()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,32);
        Assert.assertTrue(player.canUp);
        player.collision();
        Assert.assertFalse(player.canUp);

        Player player2 = new Player(32,64);
        Assert.assertTrue(player2.canUp);  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(player2.canUp);
    }

    @Test
    public void testCollisionCanDown()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(64,32);
        Assert.assertTrue(player.canDown);
        player.collision();
        Assert.assertFalse(player.canDown);

        Player player2 = new Player(32,32);
        Assert.assertTrue(player2.canDown);  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(player2.canDown);
    }
}

