public class EndPoint extends Cell 
{
	// Constructor
	public EndPoint(int x, int y)
	{
		//this.locked = true;
		super.setOccupied(false);
		super.setPosition(x,y);
		super.setContents("EndPoint");
		System.out.println("The end point has been set in location: (" + x + ", " + y +")");
	}

	public void onHit(Hero hero)
	{
		if (hero.getKeys() == 5)
		{
			System.out.println("Game over, you win!");	// trigger end of game
			System.out.println("Your score: " + hero.getScore());
		} 
		else
		{
			System.out.println("You have't collect all keys");
		}
	}
}