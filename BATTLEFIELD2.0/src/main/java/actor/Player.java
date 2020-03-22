package actor;

import board.EndPoint;
import board.TestLevel;
import board.Tile;
import hazard.Bomb;
import hazard.ScoreBomb;
import image.Images;
import playgame.Main;
import reward.Freeze;
import reward.HealthReward;
import reward.KeyReward;
import window.Window;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import static board.Tile.TILESIZE;

public class Player {
    public static float x; //position
    public static float y;

    // Fix speeds, only need just one.
    public static final int SIZE = 32;
    public static int score = 0;
    public static int keyCount = 0;
    public float leftSpeed = 2.5f;
    public float rightSpeed = 2.5f;
    public float upSpeed = 2.5f;
    public float downSpeed = 2.5f; //rate at which player moves

    public static boolean movingLeft, movingRight, movingUp, movingDown, canUp, canDown, canRight, canLeft;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        canUp = true;
        canDown = true;
        canLeft = true;
        canRight = true;
    }

    // get position of hero by rectangle
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, SIZE, SIZE);
    }


    public void collision(){
        /*int left = (int)((x - 1)/ TILESIZE);
        int right = (int)((x + 1)/ TILESIZE);
        int up = (int)((y - 1)/ TILESIZE);
        int down = (int)((y + 1)/ TILESIZE);*/

        int dx; // hero current tile x index
        if (x - (int)(x/ TILESIZE)*TILESIZE >= 16)
            dx = (int)(x/ TILESIZE)+1;
        else
            dx = (int)(x/ TILESIZE);

        int dy; // hero current tile y index
        if (y - (int)(y/ TILESIZE)*TILESIZE >= 16)
            dy = (int)(y/ TILESIZE)+1;
        else
            dy = (int)(y/ TILESIZE);


        for(int i = 0; i < Main.enemies.size(); i++){
            if(Main.enemies.get(i).getBounds().intersects(this.getBounds())){
                if(Health.hp % 30 == 0){
                    Health.bar.remove(Health.index);
                    Health.hp -= 1;
                    Health.heartsLeft--;
                }else{
                    Health.hp -= Enemy.damage;
                }
                //have an hp value and only remove if the value drops to a certain amount
            }
        }
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
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof ScoreBomb){
                ScoreBomb sb = (ScoreBomb)TestLevel.tiles[dx][dy].getContents();
                sb.onHit();
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof EndPoint){
                EndPoint e = (EndPoint)TestLevel.tiles[dx][dy].getContents();
                e.onHit();
            }
        }

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

        /*if(TestLevel.tiles[left][dy].isBarrier()){
            canLeft = false;
        }else{
            canLeft = true;
        }
        if(TestLevel.tiles[right][dy].isBarrier()){
            canRight = false;
        }else{
            canRight = true;
        }
        if(TestLevel.tiles[dx][up].isBarrier()){
            canUp = false;
        }else{
            canUp = true;
        }
        if(TestLevel.tiles[dx][down].isBarrier()){
            canDown = false;
        }else{
            canDown = true;
        }*/
    }

    public void update(Graphics2D g) {
        g.drawImage(Images.testPlayer, (int)x, (int)y, SIZE, SIZE, null);
        //update player movement based on user input
        if(movingLeft && canLeft) {
            x -= leftSpeed;
            if (x >= 577)
                x = 576;
        }
        if(movingRight && canRight) {
            x += rightSpeed;
            if (x >= 577)
                x = 576;
        }
        if(movingUp && canUp) {
            y -= upSpeed;
            if (y >= 577)
                y = 576;
        }
        if(movingDown && canDown) {
            y += downSpeed;
            if (y >= 577)
                y = 576;
        }

        collision();
    }
}



