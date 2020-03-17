import java.awt.*;

public abstract class Reward
{
    public int x, y;      // position
    public Image img;

    public Reward(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void onHit(){

    };

    public void update(Graphics2D g){

    };
}
