package actor;

import image.Images;

import java.awt.*;

public class HealthBar{

    public int x, y;

    public HealthBar(int x, int y){
        this.x = x;
        this.y = y;
    }


    public void update(Graphics2D g){
        g.drawImage(Images.testHearts, x, y, 32, 32,null);
    }
}


