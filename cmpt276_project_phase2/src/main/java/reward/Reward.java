package reward;

import actor.Hero;
import cell.Cell;
import content.Cellcontent;

//this class is a skeleton class for all rewards
public abstract class Reward implements Cellcontent
{
    private int[] position;

    public void setPosition(int x, int y)
    {
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
    }

    public int[] getPosition()
    {
        return this.position;
    }

    public void setContent(Object content, Cell regularcell) {}
    public void removeContent(Object content, Cell regularcell) {}

    //in order to update the rewards:
    public abstract void tick();

    //hit
    public void onHit(Hero hero) {}



}
