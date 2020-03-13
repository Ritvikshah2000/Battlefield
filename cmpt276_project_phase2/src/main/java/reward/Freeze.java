package reward;

import actor.Hero;
import cell.Cell;

public class Freeze extends Reward
{
    protected int freeze;
    private int lifeTime;

    //constructor
    public Freeze(Cell regularcell)
    {
        int[] position = regularcell.getPosition();
        super.setPosition(position[0], position[1]);
        this.freeze = 3;                            // default to freeze enemy for 3 seconds

        this.setContent(this, regularcell);
        System.out.println("The freeze has been set in location: (" + position[0] + ", " + position[1] +")");
    }

    //getting methods from reward and overriding them

    public void onHit(Hero hero)
    {
        System.out.println("The enemies have been frozen for 10 seconds!");
    }

    public void tick()
    {

    }

    public void setContent(Freeze freeze, Cell regularcell)
    {
        regularcell.setFreeze(freeze);
    }

    public void removeContent(Cell regularcell)
    {
        regularcell.removeFreeze();
    }
}
