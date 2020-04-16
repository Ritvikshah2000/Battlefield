package actor;

import board.EndPoint;
import board.TestLevel;
import board.Tile;
import hazard.Bomb;
import image.Images;
import playgame.Main;
import reward.Freeze;
import reward.HealthReward;
import reward.KeyReward;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import static board.Tile.TILESIZE;

public class Player {
    public static float x; //position
    public static float y;

    // Fix speeds, only need just one.
    public static final int SIZE = 32;
    private static int score;
    private static int keyCount;
    private int leftSpeed = 2;
    private int rightSpeed = 2;
    private int upSpeed = 2;
    private int downSpeed = 2; //rate at which player moves

    private static boolean movingLeft, movingRight, movingUp, movingDown, canUp, canDown, canRight, canLeft;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        canUp = true;
        canDown = true;
        canLeft = true;
        canRight = true;
        score = 0;
        keyCount = 0;
    }

    /*---------------------------------getter setter---------------------------------*/

    public Rectangle getBounds(){ return new Rectangle((int)x, (int)y, SIZE, SIZE); }

    public static int getKeyCount() { return keyCount; }

    public static int getScore() { return score; }

    public static boolean getCanLeft() { return canLeft; }

    public static boolean getCanRight() { return canRight; }

    public static boolean getCanUp() { return canUp; }

    public static boolean getCanDown() { return canDown; }

    public static void setScore(int amount) { score += amount; }

    public static void IncreaseKeyCount() { keyCount++; }

    public static void setMovingLeft(boolean b) { movingLeft = b; }

    public static void setMovingRight(boolean b) { movingRight = b; }

    public static void setMovingUp(boolean b) { movingUp = b; }

    public static void setMovingDown(boolean b) { movingDown = b; }

    public static boolean getMovingLeft() { return movingLeft; }

    public static boolean getMovingRight() { return movingRight; }

    public static boolean getMovingUp() { return movingUp; }

    public static boolean getMovingDown() { return movingDown; }

    /*-------------------------------------------------------------------------------*/


    public int[] currentTile()  //hero current tile
    {
        int[] currentTile = new int[2];
        int dx;
        if (x - (int)(x/ TILESIZE)*TILESIZE >= 16)
            dx = (int)(x/ TILESIZE)+1;
        else
            dx = (int)(x/ TILESIZE);

        int dy;
        if (y - (int)(y/ TILESIZE)*TILESIZE >= 16)
            dy = (int)(y/ TILESIZE)+1;
        else
            dy = (int)(y/ TILESIZE);

        currentTile[0] = dx;
        currentTile[1] = dy;
        return currentTile;
    }

    public void collideEnemy()  // collide with enemy
    {
        for(int i = 0; i < Main.getEnemy().size(); i++)
            if(Main.getEnemy().get(i).getBounds().intersects(this.getBounds())){
                if(Main.getHealth().getHp() % 30 == 0){    //have an hp value and only remove if the value drops to a certain amount
                    Main.getHealth().getBar().remove(Health.getIndex());
                    Main.getHealth().increaseHp(-Enemy.damage);
                    Main.getHealth().decreaseHeartLeft();    // heart bar index -1
                }else {
                    Health.increaseHp(-Enemy.damage);
                }
            }
    }

    public void collideContent(int dx, int dy)      // hit a content
    {
        if(TestLevel.tiles[dx][dy].hasContents())
        {
            if(TestLevel.tiles[dx][dy].getContents() instanceof Bomb) {
                Bomb b = (Bomb)TestLevel.tiles[dx][dy].getContents();
                b.onHit();
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof Freeze){
                Freeze f = (Freeze)TestLevel.tiles[dx][dy].getContents();
                f.onHit();
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof HealthReward){
                HealthReward hr = (HealthReward)TestLevel.tiles[dx][dy].getContents();
                hr.onHit();
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof KeyReward){
                KeyReward kr = (KeyReward)TestLevel.tiles[dx][dy].getContents();
                kr.onHit();
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof EndPoint){
                EndPoint e = (EndPoint)TestLevel.tiles[dx][dy].getContents();
                e.onHit();
            }
        }
    }

    public void checkMove()
    {
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

    public void collision(){

        int[] currentTile = currentTile();
        int dx = currentTile[0]; // hero current tile x index
        int dy = currentTile[1]; // hero current tile y index

        collideEnemy();

        collideContent(dx, dy);

        checkMove();
    }

    public void update(Graphics2D g) {
        collision();
        if (g != null)
            g.drawImage(Images.testPlayer, (int)x, (int)y, SIZE, SIZE, null);
        //update player movement based on user input
        if(movingLeft && canLeft)
            x -= leftSpeed;
        if(movingRight && canRight)
            x += rightSpeed;
        if(movingUp && canUp)
            y -= upSpeed;
        if(movingDown && canDown)
            y += downSpeed;
    }
}



