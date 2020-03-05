public class Hero extends Cell
{
	private int health;
	private int keys;
	private int score;
	private static int[] start_point;
	private EndPoint endpoint;

	//Constrctor
	public Hero(int x, int y)
	{
		super.setOccupied(true);
		super.setPosition(x, y);
		super.setContents("Hero");
		this.health = 5;
		this.score = 0;
		this.keys = 0;
		this.start_point = super.getPosition();
		System.out.println("The hero has been set in location: (" + x + ", " + y +")");
	}

	// score
	public void addScore(int score)
	{
		this.score += score;
	}

	public void reduceScore()
	{
		this.score -= score;
	}

	public int getScore()
	{
		return this.score;
	}

	//increase keys
	public void addKeys()
	{
		this.keys += 1;
	}

	public int getKeys()
	{
		return this.keys;
	}

	// reduce health
	public void reduceHealth()
	{
		this.health -= 1;
	}

	public int getHealth()
	{
		return this.health;
	}

	public void doAction(Cell cell)		// Base on the hero move to the next cell do action.
	{
		int[] posi = cell.getPosition();
		int x_posi = posi[0];
		int y_posi = posi[1];
		String cellContents = cell.getContents();
		if (cellContents == "RegularCell") 
		{ 
			this.setPosition(x_posi, y_posi);
			cell.onHit(this); 
		}
		else if (cellContents == "Barrier") 
		{ 
			cell.onHit(this);
		}
		else if (cellContents == "EndPoint") 
		{ 
			this.setPosition(x_posi, y_posi);
			cell.onHit(this);
		}
		/*-----------------------------------------------*/

		/*    continue implement for reward and hazard   */

		/*-----------------------------------------------*/
	}

	public void Move(Cell[][] board, Direction d)
	{
		int[] posi = this.getPosition();
		int x_posi = posi[0];
		int y_posi = posi[1];
		switch(d)
		{
			case down:
				this.doAction(board[x_posi+1][y_posi]);
				break;
			case up:
				this.doAction(board[x_posi-1][y_posi]);
				break;
			case right:
				this.doAction(board[x_posi][y_posi+1]);
				break;
			case left:
				this.doAction(board[x_posi][y_posi-1]);
				break;
			case stay:
				break;
		}
	}



	
	/*-----------------------------------------------*/

	/*    uncomment it when Hazard is available      */

	/*-----------------------------------------------*/


	/*public void damage(Hazard hazard)
	{	
		if (hazard.getType() == "RedBomb")
		{
			System.out.println("You hit a Red Bomb");
			this.reduceHealth();
		}

		if (hazard.getType() == "Bomb")
		{
			System.out.println("You hit a Bomb");
			this.reduceScore();
			if (this.getScore() < 0)
			{
				System.out.println("Game over! You lose");
				System.out.println("Your score is: " + this.getScore());
			}
		}*/

		/*-----------------------------------------------*/

		/*    continue implement for other hazard        */

		/*-----------------------------------------------*/
	//}
}












