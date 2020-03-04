public class RegularCell extends Cell
{
	// Constructor
	public RegularCell(int x, int y)
	{
		super.setOccupied(false);
		super.setPosition(x,y);	
		super.setContents("RegularCell");
		System.out.println("A regular cell has been set in location: (" + x + ", " + y +")");
	}
}