public abstract class Cell
{
	//attributes
	private int[] position;				// position[0] = x, position[1] = y
	private String contents;


/*-----------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------Setter, Getter, Remover--------------------------------------------*/

/*-----------------------------------------------------------------------------------------------------------------*/

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

	/*-----------------------------------------------------------------------------------------------------------------*/


	// onHit
	public void onHit(Hero hero) {}

	// will be override
	public void Move(Cell[][] board, Direction d) {}

	// will be override
	public void addKeys() {}

	public void removeHero() {}

	public void removeEnemy() {}

	public void removeHealthbomb() {}

	public void removeScorebomb() {}












}