public class EndPoint extends Cell 
{
	private boolean locked;

	// Constructor
	public EndPoint(int x, int y)
	{
		this.locked = true;
		super.setOccupied(false);
		super.setPosition(x,y);
		super.setContents("EndPoint");
		System.out.println("The end point has been set in location: (" + x + ", " + y +")");
	}

	public boolean isLocked()
	{
		return this.locked;
	}

	public void unlock()
	{
		this.locked = false;
	}
}