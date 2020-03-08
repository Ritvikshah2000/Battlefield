public class ScoreBomb extends Hazard
{
	//Constructor
	public ScoreBomb(RegularCell regularcell)
	{
		int[] position = regularcell.getPosition();
		super.setPosition(position[0], position[1]);
		super.setContents("ScoreBomb");
		this.HealthReduceValue = 0;
		this.ScoreReduceValue = 20;

		regularcell.setScorebomb(this);
		System.out.println("The ScoreBomb has been set in location: (" + position[0] + ", " + position[1] +")");
	}
}