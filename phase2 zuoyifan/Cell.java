public abstract class Cell
{
	//attributes
	private boolean occupied;
	private int[] position;				// position[0] = x, position[1] = y
	private String contents;

	//Occupied
	public boolean isOccupied()
	{
		return occupied;
	}

	public void setOccupied(boolean b)
	{
		this.occupied = b;
	}

	//Position
	public void setPosition(int x, int y)
	{
		this.position = new int[2];
		this.position[0] = x;
		this.position[1] = y;
	}

	public int[] getPosition()
	{
		return this.position;
	}

	// Contents
	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public String getContents()
	{
		return this.contents;
	}
}