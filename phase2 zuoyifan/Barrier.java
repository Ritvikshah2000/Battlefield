public class Barrier extends Cell 
{
	private boolean isBarrier;

	// Constructor
	public Barrier(int x, int y)
	{
		super.setOccupied(true);
		super.setPosition(x,y);		
		super.setContents("Barrier");	
		this.isBarrier = true;			
		System.out.println("A barrier has been set in location: (" + x + ", " + y +")");
	}

	//Barrier checker
	public boolean isBarrier()
	{
		return this.isBarrier;
	}
}