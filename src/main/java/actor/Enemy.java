package actor;

import board.TestLevel;
import board.Tile;
import image.Images;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public final class Enemy {

    private int x;
    private int y;
    private int speed = 1;
    private int enemyImageId;
    private boolean canUp;
    private boolean canDown;
    private boolean canRight;
    private boolean canLeft;
    private static boolean isFrozen;
    private int frozenTimer;
    private static final int SIZE = 32;

    private static float damage = 0.5f;

    public Enemy(final int x, final int y, final int imageId) {
        this.x = x;
        this.y = y;
        enemyImageId = imageId;
        canUp = true;
        canDown = true;
        canLeft = true;
        canRight = true;
        isFrozen = false;
        frozenTimer = 0;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean getCanUp(){
        return canUp;
    }
    public boolean getCanDown(){
        return canDown;
    }
    public boolean getCanLeft(){
        return canLeft;
    }
    public boolean getCanRight(){
        return canRight;
    }

    public static float getDamage(){
        return damage;
    }

    public int getFrozenTimer(){
        return frozenTimer;
    }

    public void setFrozenTimer(int time){
        frozenTimer = time;
    }

    public static boolean getIsFrozen(){
        return isFrozen;
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
                switch(enemyImageId){
                    case 1:
                        g.drawImage(Images.getEnemyImage(), x, y, SIZE, SIZE, null);
                        break;
                    case 2:
                        g.drawImage(Images.getEnemy2Image(), x, y, SIZE, SIZE, null);
                        break;
                    case 3:
                        g.drawImage(Images.getEnemy3Image(), x, y, SIZE, SIZE, null);
                        break;
                }
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
                g.drawImage(Images.getEnemyFrozenImage(), (int)x, (int)y, SIZE, SIZE, null);
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

    public void update(final Graphics2D g) {
        collision();
        checkFrozen();
        chasingHero(g);
    }
}


