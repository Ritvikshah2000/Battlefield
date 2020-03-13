package hazard;

import cell.Cell;

public class HealthBomb extends Hazard
{
    //Constructor
    public HealthBomb(Cell regularcell)
    {
        int[] position = regularcell.getPosition();
        super.setPosition(position[0], position[1]);
        this.HealthReduceValue = 1;
        this.ScoreReduceValue = 0;

        this.setContent(this, regularcell);
        System.out.println("The HealthBomb has been set in location: (" + position[0] + ", " + position[1] +")");
    }

    public void setContent(HealthBomb healthbomb, Cell regularcell)
    {
        regularcell.setHealthbomb(healthbomb);
    }

    public void removeContent(Cell regularcell)
    {
        regularcell.removeHealthbomb();
    }


}
