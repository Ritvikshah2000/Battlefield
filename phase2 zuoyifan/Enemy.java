import java.lang.Math;

public class Enemy extends Hazard
{
	//Constructor
	public Enemy(RegularCell regularcell)
	{
		int[] position = regularcell.getPosition();
		super.setPosition(position[0], position[1]);
		super.setContents("Enemy");
		this.HealthReduceValue = Integer.MAX_VALUE;
		this.ScoreReduceValue = 0;

		regularcell.setEnemy(this);
		System.out.println("The Enemy has been set in location: (" + position[0] + ", " + position[1] +")");
	}


	public void doAction(Cell currentcell, Cell nextcell)		// Base on the hero move to the next cell do action.
	{
		int[] cellposition = nextcell.getPosition();
		String cellContents = nextcell.getContents();

		if (cellContents == "RegularCell") 
		{ 	
			currentcell.removeEnemy();
			this.setPosition(cellposition[0], cellposition[1]);
			nextcell.onHit(this);
		}
		else if (cellContents == "Barrier") 
		{ 
			nextcell.onHit(this);
		}
		else if (cellContents == "EndPoint") 
		{ 
			// do nothing, enemy can not enter end point
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

	public void chasing(Cell[][] board, Hero hero)			// chasing hero base on shortest distance 
	{
		int[] hero_position = hero.getPosition();
		double hero_x_posi = (double) hero_position[0];
		double hero_y_posi = (double) hero_position[1];
		int[] enemy_position = this.getPosition();
		double enemy_x_posi = (double) enemy_position[0];
		double enemy_y_posi = (double) enemy_position[1]; 

		double moveup = Math.sqrt(((enemy_x_posi-1)-hero_x_posi)*((enemy_x_posi-1)-hero_x_posi) + (enemy_y_posi-hero_y_posi)*(enemy_y_posi-hero_y_posi));
		double min = moveup;
		double movedown = Math.sqrt(((enemy_x_posi+1)-hero_x_posi)*((enemy_x_posi+1)-hero_x_posi) + (enemy_y_posi-hero_y_posi)*(enemy_y_posi-hero_y_posi));
		if (movedown < min)
		{
			min = movedown;
		}
		double moveright = Math.sqrt((enemy_x_posi-hero_x_posi)*(enemy_x_posi-hero_x_posi) + ((enemy_y_posi+1)-hero_y_posi)*((enemy_y_posi+1)-hero_y_posi));
		if (moveright < min)
		{
			min = moveright;
		}
		double moveleft = Math.sqrt((enemy_x_posi-hero_x_posi)*(enemy_x_posi-hero_x_posi) + ((enemy_y_posi-1)-hero_y_posi)*((enemy_y_posi-1)-hero_y_posi));
		if (moveleft < min)
		{
			min = moveleft;
		}

		if (min == moveup)
		{
			this.Move(board, Direction.up);
		}

		else if (min == movedown)
		{
			this.Move(board, Direction.down);
		}

		else if (min == moveright)
		{
			this.Move(board, Direction.right);
		}

		else if (min == moveleft)
		{
			this.Move(board, Direction.left);
		}
	}
}













