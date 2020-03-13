package game;

import actor.Direction;
import actor.Enemy;
import actor.Hero;
import cell.Cell;
import cell.ID;
import cell.RegularCell;
import hazard.ScoreBomb;

public class PlayGame
{
    public static void printHero(Hero hero)
    {
        int[] position = hero.getPosition();
        System.out.println("The position of hero is: (" + position[0] + ", " + position[1] + ")");
        System.out.println("The hero now has score: " + hero.getScore());
        System.out.println("The hero now has health: " + hero.getHealth());
        System.out.println("The hero now has key: " + hero.getKeys());
        System.out.println(" ");
    }

    public static void main(String[] args)
    {
        Board board = new Board();
        Hero hero = new Hero(board.getHerocell());
        Enemy[] enemies = board.getEnemylist();
        System.out.println(" ");
        for (int i=0; i<3; i+=1)
        {
            for (int j=0; j<3; j+=1)		// all enemies chasing hero
            {
                enemies[j].chasing(board.getCell(), hero);
                int[] posi = enemies[j].getPosition();
                int x = posi[0];
                int y = posi[1];
                System.out.println("The Enemy " + j + " is now in location: (" + posi[0] + ", " + posi[1] +")");
            }
            hero.Move(board.getCell(), Direction.left);       // hero move
            printHero(hero);
            System.out.println(" ");
            System.out.println(" ");
        }
        // continue implement
    }
}
