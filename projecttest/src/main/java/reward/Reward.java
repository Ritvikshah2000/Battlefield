package reward;

import java.awt.*;

public abstract class Reward
{
    public float x, y;      // position
    private int width, height = 16;
    public Image img;

    public Reward(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(Graphics2D g)
    {
        g.drawImage(img, (int)x, (int)y, width, height, null);
    }
}
