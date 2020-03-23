package actor;

import board.TestLevel;
import board.Tile;
import image.Images;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Enemy{

    public int x,y;
    public float speed = 1.0f;
    public boolean canUp, canDown, canRight, canLeft;
    public static boolean isFrozen;
    public int frozenTimer;
    public static final int SIZE = 32;

    public static int damage = 1;

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
        return new Rectangle((int)x, (int)y, SIZE, SIZE);
    }

    public void update(Graphics2D g) {

        if(frozenTimer != 0){
            isFrozen = true;
            frozenTimer -= 1;
        }else{
            isFrozen = false;
        }

        if(!isFrozen){
            g.drawImage(Images.testEnemy, (int)x, (int)y, SIZE, SIZE, null);
            if(Player.x > x && canRight) {
                x += speed;
            }
            if(Player.y > y && canDown) {
                y += speed;
            }
            if(Player.x < x && canLeft) {
                x -= speed;
            }
            if(Player.y < y && canUp) {
                y -= speed;
            }
        }
        else
        {
            g.drawImage(Images.testEnemyFrozen, (int)x, (int)y, SIZE, SIZE, null);
        }

        collision();
    }

    public void collision(){

        Rectangle herorect = this.getBounds();
        Rectangle barrierrect = null;

        // check can left
        canLeft = true;
        for (int i=0; i<TestLevel.barrierList.size(); i++)
        {
            Tile barrier = TestLevel.barrierList.get(i);
            barrierrect = new Rectangle(barrier.x+2, barrier.y, barrier.width, barrier.height);
            if (herorect.intersects(barrierrect)) {
                canLeft = false;
                break;
            }
        }

        // check can right
        canRight = true;
        for (int i=0; i<TestLevel.barrierList.size(); i++)
        {
            Tile barrier = TestLevel.barrierList.get(i);
            barrierrect = new Rectangle(barrier.x-2, barrier.y, barrier.width, barrier.height);
            if (herorect.intersects(barrierrect)) {
                canRight = false;
                break;
            }
        }

        // check can up
        canUp = true;
        for (int i=0; i<TestLevel.barrierList.size(); i++)
        {
            Tile barrier = TestLevel.barrierList.get(i);
            barrierrect = new Rectangle(barrier.x, barrier.y+2, barrier.width, barrier.height);
            if (herorect.intersects(barrierrect)) {
                canUp = false;
                break;
            }
        }

        // check can down
        canDown = true;
        for (int i=0; i<TestLevel.barrierList.size(); i++)
        {
            Tile barrier = TestLevel.barrierList.get(i);
            barrierrect = new Rectangle(barrier.x, barrier.y-2, barrier.width, barrier.height);
            if (herorect.intersects(barrierrect)) {
                canDown = false;
                break;
            }
        }
    }

}


