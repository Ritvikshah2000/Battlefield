package actor;

import java.awt.Color;
import java.awt.Graphics2D;


public class Health{
    public static int hp = 100;

    public void update(Graphics2D g){
        g.setColor(Color.pink);
        g.fillRect(25, 25, hp*2, 50);
    }
}
