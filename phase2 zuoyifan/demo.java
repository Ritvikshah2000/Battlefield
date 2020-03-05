public class demo
{
	public static void printPosition(Cell cell)
	{
		int[] position = cell.getPosition();
		String contents = cell.getContents(); 
		System.out.println("The position of " + contents + " is: (" + position[0] + ", " + position[1] + ")");
	}

	public static void main(String[] args)
	{
		CellFactory cellfactory = new CellFactory();
		Cell barrier = cellfactory.getCell("Barrier", 0, 0);
		Cell regularcell = cellfactory.getCell("RegularCell", 1, 0);
		Cell endpoint = cellfactory.getCell("EndPoint", 1, 1);
		Cell hero = new Hero(0,1);
		System.out.println("In cell1 is a " + barrier.getContents());
		System.out.println("In cell2 is a " + regularcell.getContents());
		System.out.println("In cell3 is a " + endpoint.getContents());
		System.out.println("In cell4 is a " + hero.getContents());
		Cell[][] board = new Cell[2][2];
		board[0][0] = barrier;
		board[1][0] = regularcell;
		board[0][1] = hero;
		board[1][1] = endpoint;
		hero.Move(board, Direction.left);
		printPosition(hero);
		hero.Move(board, Direction.down);
		printPosition(hero);
		hero.Move(board, Direction.left);
		printPosition(hero);
		for (int i=0; i<5; i++)
		{
			hero.addKeys();
		}
		hero.Move(board, Direction.right);
		printPosition(hero);
	}
}