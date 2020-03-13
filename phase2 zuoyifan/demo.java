public class demo
{
    public static void printHero(Hero hero)
    {
        int[] position = hero.getPosition();
        System.out.println("The position of hero is: (" + position[0] + ", " + position[1] + ")");
        System.out.println("The hero now has score: " + hero.getScore());
        System.out.println("The hero now has health: " + hero.getHealth());
        System.out.println("The hero now has key: " + hero.getKeys());
    }

    public static void main(String[] args)
    {
        CellFactory cellfactory = new CellFactory();
        Cell c1 = cellfactory.getCell("RegularCell", 0, 0);
        Cell c2 = cellfactory.getCell("RegularCell", 0, 1);
        Cell c3 = cellfactory.getCell("RegularCell", 0, 2);

        Cell[][] board = new Cell[1][3];
        board[0][0] = c1;
        board[0][1] = c2;
        board[0][2] = c3;

        Hero hero = new Hero(c1);
        Key key = new Key(c2);
        Enemy enemy = new Enemy(c3);
        
        printHero(hero);

        c1.printcell();
        c2.printcell();
        c3.printcell();

        enemy.Move(board, Direction.left);
        hero.Move(board, Direction.stay);
        c1.printcell();
        c2.printcell();
        c3.printcell();
        printHero(hero);

        enemy.Move(board, Direction.left);
        hero.Move(board, Direction.stay);
        c1.printcell();
        c2.printcell();
        c3.printcell();
        printHero(hero);

    }
}