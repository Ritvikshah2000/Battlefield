
public class ScoreBomb extends Hazard
{
    //Constructor
    public ScoreBomb(Cell regularcell)
    {
        int[] position = regularcell.getPosition();
        super.setPosition(position[0], position[1]);
        this.HealthReduceValue = 0;
        this.ScoreReduceValue = 20;

        this.setContent(this, regularcell);
        System.out.println("The ScoreBomb has been set in location: (" + position[0] + ", " + position[1] +")");
    }

    public void setContent(ScoreBomb scorebomb, Cell regularcell)
    {
        regularcell.setScorebomb(scorebomb);
    }

    public void removeContent(Cell regularcell)
    {
        regularcell.removeScorebomb();
    }
}