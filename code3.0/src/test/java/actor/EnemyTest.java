package actor;


import board.TestLevel;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;


public class EnemyTest {

    @Test
    public void testEnemyConstructor()
    {
        Enemy enemy = new Enemy(32,16);
        Assert.assertEquals(32, enemy.x);
        Assert.assertEquals(16, enemy.y);
        Assert.assertEquals(0, enemy.frozenTimer);
        Assert.assertTrue(enemy.canLeft);
        Assert.assertTrue(enemy.canRight);
        Assert.assertTrue(enemy.canUp);
        Assert.assertTrue(enemy.canDown);
    }

    @Test
    public void testGetBounds()     // test getBounds return correct result.
    {
        Enemy enemy = new Enemy(1,2);
        Rectangle rectangle = enemy.getBounds();
        Assert.assertEquals(1,rectangle.x);
        Assert.assertEquals(2,rectangle.y);
        Assert.assertEquals(32,rectangle.width);
        Assert.assertEquals(32,rectangle.height);
    }


    /*--------------------------------------Collision()------------------------------------------*/

    @Test
    public void testCollisionCanLeft()      // test canLeft in collision
    {
        TestLevel level = new TestLevel(2);

        Enemy enemy = new Enemy(32,32);
        Assert.assertTrue(enemy.canLeft);   // check initially canLeft is true
        enemy.collision();
        Assert.assertFalse(enemy.canLeft);  // in level there is barrier in the left hand side of enemy, canLeft become false

        Enemy enemy2 = new Enemy(64,32);
        Assert.assertTrue(enemy2.canLeft);  // check initially canLeft is true
        enemy2.collision();
        Assert.assertTrue(enemy2.canLeft);  // in level there is no barrier in the left hand side of enemy2, canLeft should be true
    }

    @Test
    public void testCollisionCanRight()
    {
        TestLevel level = new TestLevel(2);

        Enemy enemy = new Enemy(32,64);
        Assert.assertTrue(enemy.canRight);
        enemy.collision();
        Assert.assertFalse(enemy.canRight);

        Enemy enemy2 = new Enemy(32,32);
        Assert.assertTrue(enemy2.canRight);
        enemy2.collision();
        Assert.assertTrue(enemy2.canRight);
    }

    @Test
    public void testCollisionCanUp()
    {
        TestLevel level = new TestLevel(2);

        Enemy enemy = new Enemy(32,32);
        Assert.assertTrue(enemy.canUp);
        enemy.collision();
        Assert.assertFalse(enemy.canUp);

        Enemy enemy2 = new Enemy(32,64);
        Assert.assertTrue(enemy2.canUp);  // check initially canLeft is true
        enemy2.collision();
        Assert.assertTrue(enemy2.canUp);
    }

    @Test
    public void testCollisionCanDown()
    {
        TestLevel level = new TestLevel(2);

        Enemy enemy = new Enemy(64,32);
        Assert.assertTrue(enemy.canDown);
        enemy.collision();
        Assert.assertFalse(enemy.canDown);

        Enemy enemy2 = new Enemy(32,32);
        Assert.assertTrue(enemy2.canDown);  // check initially canLeft is true
        enemy2.collision();
        Assert.assertTrue(enemy2.canDown);
    }

    @Test
    public void testCheckFrozen()
    {
        Enemy enemy = new Enemy(64,32);
        enemy.checkFrozen();
        Assert.assertFalse(Enemy.isFrozen);
        Assert.assertEquals(0, enemy.frozenTimer);

        enemy.frozenTimer = 2;
        enemy.checkFrozen();
        Assert.assertTrue(Enemy.isFrozen);
        Assert.assertEquals(1, enemy.frozenTimer);
        enemy.checkFrozen();
        Assert.assertTrue(Enemy.isFrozen);
        Assert.assertEquals(0, enemy.frozenTimer);
        enemy.checkFrozen();
        Assert.assertFalse(Enemy.isFrozen);
        Assert.assertEquals(0, enemy.frozenTimer);
    }


    /*-----------------------------------chasingHero()----------------------------------------*/

    @Test
    public void testChasingHero()
    {
        Enemy enemy = new Enemy(64, 128);
        Player hero = new Player(32,32);

        enemy.frozenTimer = 0;
        enemy.chasingHero(null);          // enemy will chasing hero by left and up direction
        Assert.assertEquals(63, enemy.x);
        Assert.assertEquals(127, enemy.y);

        hero.x = 256;   // change hero position
        hero.y = 300;

        enemy.chasingHero(null);          // enemy will chasing hero by right and down direction
        Assert.assertEquals(64, enemy.x);
        Assert.assertEquals(128, enemy.y);
    }
}