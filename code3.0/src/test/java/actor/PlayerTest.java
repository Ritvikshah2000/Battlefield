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
        Assert.assertTrue(player.getCanLeft());
        Assert.assertTrue(player.getCanRight());
        Assert.assertTrue(player.getCanUp());
        Assert.assertTrue(player.getCanDown());
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


    @Test
    public void testCheckMoveCanLeft()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,32);
        Assert.assertTrue(player.getCanLeft());   // check initially canLeft is true
        player.checkMove();
        Assert.assertFalse(player.getCanLeft());  // in level there is barrier in the left hand side of enemy, canLeft become false

        Player player2 = new Player(64,32);
        Assert.assertTrue(player2.getCanLeft());  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(player2.getCanLeft());  // in level there is no barrier in the left hand side of enemy2, canLeft should be true
    }

    @Test
    public void testCheckMoveCanRight()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,64);
        Assert.assertTrue(player.getCanRight());
        player.collision();
        Assert.assertFalse(player.getCanRight());

        Player player2 = new Player(32,32);
        Assert.assertTrue(player2.getCanRight());
        player2.collision();
        Assert.assertTrue(player2.getCanRight());
    }

    @Test
    public void testCheckMoveCanUp()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(32,32);
        Assert.assertTrue(player.getCanUp());
        player.collision();
        Assert.assertFalse(player.getCanUp());

        Player player2 = new Player(32,64);
        Assert.assertTrue(player2.getCanUp());  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(player2.getCanUp());
    }

    @Test
    public void testCollisionCanDown()
    {
        TestLevel level = new TestLevel(2);

        Player player = new Player(64,32);
        Assert.assertTrue(player.getCanDown());
        player.collision();
        Assert.assertFalse(player.getCanDown());

        Player player2 = new Player(32,32);
        Assert.assertTrue(player2.getCanDown());  // check initially canLeft is true
        player2.collision();
        Assert.assertTrue(player2.getCanDown());
    }
}

