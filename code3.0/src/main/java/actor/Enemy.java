package actor;

import board.TestLevel;
import board.Tile;
import image.Images;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Enemy{

    public int x,y;
    public int speed = 1;
    public boolean canUp, canDown, canRight, canLeft;
    public static boolean isFrozen;
    public int frozenTimer;
    public static final int SIZE = 32;

    public static float damage = 0.5f;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        canUp = true;
        canDown = true;
        canLeft = true;
        canRight = true;
        isFrozen = false;
        frozenTimer = 0;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, SIZE, SIZE);
    }

    public void checkFrozen()
    {
        if(frozenTimer != 0){
            isFrozen = true;
            frozenTimer -= 1;
        }else{
            isFrozen = false;
        }
    }

    public void chasingHero(Graphics2D g)
    {
        if(!isFrozen){  // chasing hero
            if (g != null)
                g.drawImage(Images.testEnemy, x, y, SIZE, SIZE, null);
            if(Player.x > this.x && canRight) {
                x += speed;
            }
            if(Player.y > this.y && canDown) {
                y += speed;
            }
            if(Player.x < this.x && canLeft) {
                x -= speed;
            }
            if(Player.y < this.y && canUp) {
                y -= speed;
            }
        }
        else
        {
            if (g != null)
                g.drawImage(Images.testEnemyFrozen, (int)x, (int)y, SIZE, SIZE, null);
        }
    }

    public void collision(){

        Rectangle enemyrect = this.getBounds();
        Rectangle barrierrect = null;

        // check can left
        canLeft = true;
        for (int i=0; i<TestLevel.barrierList.size(); i++)
        {
            Tile barrier = TestLevel.barrierList.get(i);
            barrierrect = new Rectangle(barrier.x+1, barrier.y, barrier.width, barrier.height);
            if (enemyrect.intersects(barrierrect)) {
                canLeft = false;
                break;
            }
        }

        // check can right
        canRight = true;
        for (int i=0; i<TestLevel.barrierList.size(); i++)
        {
            Tile barrier = TestLevel.barrierList.get(i);
            barrierrect = new Rectangle(barrier.x-1, barrier.y, barrier.width, barrier.height);
            if (enemyrect.intersects(barrierrect)) {
                canRight = false;
                break;
            }
        }

        // check can up
        canUp = true;
        for (int i=0; i<TestLevel.barrierList.size(); i++)
        {
            Tile barrier = TestLevel.barrierList.get(i);
            barrierrect = new Rectangle(barrier.x, barrier.y+1, barrier.width, barrier.height);
            if (enemyrect.intersects(barrierrect)) {
                canUp = false;
                break;
            }
        }

        // check can down
        canDown = true;
        for (int i=0; i<TestLevel.barrierList.size(); i++)
        {
            Tile barrier = TestLevel.barrierList.get(i);
            barrierrect = new Rectangle(barrier.x, barrier.y-1, barrier.width, barrier.height);
            if (enemyrect.intersects(barrierrect)) {
                canDown = false;
                break;
            }
        }
    }

    public void update(Graphics2D g) {
        collision();
        checkFrozen();
        chasingHero(g);
    }
}


