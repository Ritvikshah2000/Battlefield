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

public class Player {
    public Main main;
    public static float x,y; //position
    // Fix speeds, only need just one.
    public static final int SIZE = 32;
    public static int score = 0;
    public static int keyCount = 0;
    public float leftSpeed = 4.0f;
    public float rightSpeed = 4.0f;
    public float upSpeed = 4.0f;
    public float downSpeed = 4.0f; //rate at which player moves

    public static boolean movingLeft, movingRight, movingUp, movingDown, canUp, canDown, canRight, canLeft;

    public Player(float x, float y, Main main) {
        this.main = main;
        this.x = x;
        this.y = y;
        canUp = true;
        canDown = true;
        canLeft = true;
        canRight = true;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, SIZE, SIZE);
    }


    public void collision(){
        int left = (int)((x - 1)/Tile.TILESIZE);
        int right = (int)((x + SIZE)/Tile.TILESIZE);
        int up = (int)((y  - 1)/Tile.TILESIZE);
        int down = (int)((y + SIZE)/Tile.TILESIZE);
        int dx = (int)(x/Tile.TILESIZE);
        int dy = (int)(y/Tile.TILESIZE);

        for(int i = 0; i < Main.enemies.size(); i++){
            if(Main.enemies.get(i).getBounds().intersects(this.getBounds())){
                if(Health.hp % 30 == 0){
                    Health.bar.remove(Health.index);
                    Health.hp -= 1;
                    Health.heartsLeft--;
                }else{
                    Health.hp -= Enemy.damage;
                }
                System.out.println("HP: " + Health.hp + " Index: " + Health.index + " Left: " + Health.heartsLeft);
                //have an hp value and only remove if the value drops to a certain amount
            }
        }
        if(TestLevel.tiles[dx][dy].hasContents()){
            if(TestLevel.tiles[dx][dy].getContents() instanceof Bomb){
                Bomb b = (Bomb)TestLevel.tiles[dx][dy].getContents();
                b.onHit();
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof Freeze){
                Freeze f = (Freeze)TestLevel.tiles[dx][dy].getContents();
                f.onHit();
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof HealthReward){
                HealthReward hr = (HealthReward)TestLevel.tiles[dx][dy].getContents();
                hr.onHit();
            }
            else if(TestLevel.tiles[dx][dy].getContents() instanceof KeyReward)
            {
                KeyReward kr = (KeyReward)TestLevel.tiles[dx][dy].getContents();
                kr.onHit();
            }
            else if(TestLevel.tiles[dx][dy].getContents() instanceof ScoreBomb)
            {
                ScoreBomb sb = (ScoreBomb)TestLevel.tiles[dx][dy].getContents();
                sb.onHit();
            }else if(TestLevel.tiles[dx][dy].getContents() instanceof EndPoint){
                EndPoint e = (EndPoint)TestLevel.tiles[dx][dy].getContents();
                e.onHit(main);
            }
        }

        if(TestLevel.tiles[left][dy].isBarrier()){
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
        }
    }

    public void update(Graphics2D g) {
        g.drawImage(Images.testPlayer, (int)x, (int)y, SIZE, SIZE, null);

        //update player movement based on user input
        if(movingLeft && canLeft) x -= leftSpeed;
        if(movingRight && canRight) x+= rightSpeed;
        if(movingUp && canUp) y -= upSpeed;
        if(movingDown && canDown) y += downSpeed;

        collision();
    }
}


