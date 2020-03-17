package actor;

import board.TestLevel;
import board.Tile;
import image.Images;
import playgame.Main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
    public static float x,y; //position
    // Fix speeds, only need just one.
    public static final int SIZE = 32;
    public float leftSpeed = 4.0f;
    public float rightSpeed = 4.0f;
    public float upSpeed = 4.0f;
    public float downSpeed = 4.0f; //rate at which player moves

    public static boolean movingLeft, movingRight, movingUp, movingDown, canUp, canDown, canRight, canLeft;

    public Player(float x, float y) {
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


    public void collision()
    {
        int left = (int)(x/ Tile.TILESIZE);
        int right = (int)((x + SIZE)/Tile.TILESIZE);
        int up = (int)(y/Tile.TILESIZE);
        int down = (int)((y + SIZE)/Tile.TILESIZE);
        int dx = (int)(x/Tile.TILESIZE);
        int dy = (int)(y/Tile.TILESIZE);

        for(int i = 0; i < Main.enemies.size(); i++)
            if(Main.enemies.get(i).getBounds().intersects(this.getBounds()))
                Health.hp -= 10;

        if(TestLevel.tiles[left][dy].isBarrier())
            canLeft = false;
        else
            canLeft = true;
        if(TestLevel.tiles[right][dy].isBarrier())
            canRight = false;
        else
            canRight = true;
        if(TestLevel.tiles[dx][up].isBarrier())
            canUp = false;
        else
            canUp = true;
        if(TestLevel.tiles[dx][down].isBarrier())
            canDown = false;
        else
            canDown = true;
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
