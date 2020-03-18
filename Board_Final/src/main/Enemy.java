package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy{

	public int x,y;
	public float velX, velY;
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

        //x += velX;
        //y += velY;

        collision();
    }

	public void collision(){
		int left = (int)(x/Tile.TILESIZE);
		int right = (int)((x + SIZE)/Tile.TILESIZE);
		int up = (int)(y/Tile.TILESIZE);
		int down = (int)((y + SIZE)/Tile.TILESIZE);
		int dx = (int)(x/Tile.TILESIZE);
		int dy = (int)(y/Tile.TILESIZE);
		//System.out.println("l: " + left + "\nr: " + right + "\nu: " + up + "\nd: " + down);

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

}
