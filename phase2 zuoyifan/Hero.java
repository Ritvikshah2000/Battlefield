public class Hero
{
	private int[] position;
	private int health;
	private int keys;
	private int score;
	private static int[] start_point;
	private EndPoint endpoint;

	//Constrctor
	public void Hero(RegularCell regularcell)
	{
		position = regularcell.getPosition();
		this.setPosition(position[0], position[1]);
		this.health = 5;
		this.score = 0;
		this.keys = 0;
		this.start_point = this.getPosition();

		regularcell.setHero(this);
		System.out.println("The hero has been set in location: (" + position[0] + ", " + position[1] +")");
	}


/*-----------------------------------------------------------------------------------------------------------------*/

/*---------------------------------------Setter, Getter, Adder, Reducer--------------------------------------------*/

/*-----------------------------------------------------------------------------------------------------------------*/

	// Position
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

	// Score
	public void addScore(int score)
	{
		this.score += score;
	}

	public void reduceScore(int amount)
	{
		this.score -= amount;
	}

	public int getScore()
	{
		return this.score;
	}

	// Keys
	public void addKeys()
	{
		this.keys += 1;
	}

	public int getKeys()
	{
		return this.keys;
	}

	// Health
	public void reduceHealth(int amount)
	{
		this.health -= amount;
	}

	public void addHealth(int amount)
	{
		this.health += amount;
	}

	public int getHealth()
	{
		return this.health;
	}

	/*-----------------------------------------------------------------------------------------------------------------*/


	public void doAction(Cell currentcell, Cell nextcell)		// Base on the hero move to the next cell do action.
	{
		int[] cellposition = nextcell.getPosition();
		String cellContents = nextcell.getContents();

		if (cellContents == "RegularCell") 
		{ 	
			currentcell.removeHero();
			this.setPosition(cellposition[0], cellposition[1]);
			nextcell.onHit(this);
		}
		else if (cellContents == "Barrier") 
		{ 
			nextcell.onHit(this);
		}
		else if (cellContents == "EndPoint") 
		{ 
			currentcell.removeHero();
			this.setPosition(cellposition[0], cellposition[1]);
			nextcell.onHit(this);
		}
	}

	public void Move(Cell[][] board, Direction d)
	{
		int[] posi = this.getPosition();
		int x_posi = posi[0];
		int y_posi = posi[1];
		switch(d)
		{
			case down:
				this.doAction(board[x_posi][y_posi], board[x_posi+1][y_posi]);
				break;
			case up:
				this.doAction(board[x_posi][y_posi], board[x_posi-1][y_posi]);
				break;
			case right:
				this.doAction(board[x_posi][y_posi], board[x_posi][y_posi+1]);
				break;
			case left:
				this.doAction(board[x_posi][y_posi], board[x_posi][y_posi-1]);
				break;
			case stay:
				break;
		}
	}
}












