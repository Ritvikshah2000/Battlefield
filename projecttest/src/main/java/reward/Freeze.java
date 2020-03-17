package reward;

import image.Images;

import java.awt.*;

public class Freeze extends Reward
{
    private int freezetime = 3;


    public Freeze(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        this.img = Images.testFreeze;
    }


}
