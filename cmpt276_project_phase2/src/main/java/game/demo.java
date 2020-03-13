package game;

import actor.Direction;
import actor.Hero;
import cell.CellFactory;
import cell.Cell;
import cell.ID;
import cell.RegularCell;
import hazard.ScoreBomb;

public class demo
{
    public static void printPosition(Hero hero)
    {
        int[] position = hero.getPosition();
        System.out.println("The position of hero is: (" + position[0] + ", " + position[1] + ")");
        System.out.println("The hero now has score: " + hero.getScore());
    }

    public static void main(String[] args)
    {
        Cell regularcell1 = new RegularCell(0,0, ID.RegularCell);
        Cell regularcell2 = new RegularCell(0,1, ID.RegularCell);
        Cell[][] board = new Cell[1][2];
        board[0][0] = regularcell1;
        board[0][1] = regularcell2;
        regularcell1.printcell();
        regularcell2.printcell();
        Hero hero = new Hero(regularcell1);
        ScoreBomb scorebomb = new ScoreBomb(regularcell2);
        hero.Move(board, Direction.right);
        printPosition(hero);
    }
}
