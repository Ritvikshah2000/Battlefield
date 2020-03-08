public class HealthBomb extends Hazard
{
	//Constructor
	public HealthBomb(RegularCell regularcell)
	{
		int[] position = regularcell.getPosition();
		super.setPosition(position[0], position[1]);
		super.setContents("HealthBomb");
		this.HealthReduceValue = 1;
		this.ScoreReduceValue = 0;

		regularcell.setHealthbomb(this);
		System.out.println("The HealthBomb has been set in location: (" + position[0] + ", " + position[1] +")");
	}
}