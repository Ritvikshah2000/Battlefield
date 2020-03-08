public class demo
{
	public static void printPosition(Hero hero)
	{
		int[] position = hero.getPosition();
		System.out.println("The position of hero is: (" + position[0] + ", " + position[1] + ")");
	}

	public static void main(String[] args)
	{
		CellFactory cellfactory = new CellFactory();
		Cell regularcell1 = cellfactory.getCell("RegularCell", 0, 0);
		Cell regularcell2 = cellfactory.getCell("RegularCell", 0, 1);
		Cell[][] board = new Cell[1][2];
		board[0][0] = regularcell1;
		board[0][1] = regularcell2;
		Hero hero = new Hero(regularcell1);
		ScoreBomb scorebomb = new ScoreBomb(regularcell2);
		hero.Move(board, Direction.right);
		printPosition(hero);
	}
}