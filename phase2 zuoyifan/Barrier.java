public class Barrier extends Cell 
{
	// Constructor
	public Barrier(int x, int y)
	{
		super.setPosition(x,y);		
		super.setContents("Barrier");			
		System.out.println("A barrier has been set in location: (" + x + ", " + y +")");
	}

	// Hero hit a barrier
	public void onHit(Hero hero) 
	{
		// do nothing
		System.out.println("Hero hit a Barrier, position won't change");
	}

	public void onHit(Enemy enemy) 
	{
		// do nothing
		System.out.println("enmey hit a Barrier, position won't change");
	}
}