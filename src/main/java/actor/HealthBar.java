package actor;

import image.Images;

import java.awt.*;


public class HealthBar{

    private int x, y;

    public HealthBar(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void update(Graphics2D g){
        g.drawImage(Images.getHeartsImage(), x, y, 32, 32,null);
    }
}



