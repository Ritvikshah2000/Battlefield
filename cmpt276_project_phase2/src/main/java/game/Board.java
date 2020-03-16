package game;

import actor.Enemy;
import actor.Hero;
import cell.Cell;
import cell.CellFactory;
import hazard.HealthBomb;
import hazard.ScoreBomb;
import reward.Freeze;
import reward.Health;
import reward.Key;

import java.util.ArrayList;

public class Board
{
    private int[][] map = { {0,0,0,0,0,0,0,0,0,0},
                            {0,8,6,1,2,1,7,1,2,0},
                            {0,7,1,0,0,1,1,0,1,0},
                            {0,1,1,1,1,1,1,0,1,0},
                            {0,0,0,1,4,1,1,1,1,0},
                            {0,1,1,1,1,2,1,5,1,0},
                            {0,1,5,1,0,0,0,1,1,0},
                            {0,3,1,1,1,1,1,1,1,0},
                            {0,2,7,6,1,1,2,1,9,0},
                            {0,0,0,0,0,0,0,0,0,0} };
    private Cell[][] board;
    private ArrayList<Key> keyList = new ArrayList<Key>();
    private ArrayList<Health> healthList = new ArrayList<Health>();
    private ArrayList<Freeze> freezeList = new ArrayList<Freeze>();
    private ArrayList<HealthBomb> healthbombList = new ArrayList<HealthBomb>();
    private ArrayList<ScoreBomb> scorebombList = new ArrayList<ScoreBomb>();
    private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    private int n = 10;

    public Board()
    {
        int n = 10;     // n is size of the matrix

        /*-----------------------------Board-----------------------------*/

        // 0 = barrier, 1 = emptyregularcell, 2 = key, 3 = health, 4 = freeze, 5 = healthbomb, 6 = scorebomb, 7 = enmey, endpoint = 8
        // 9 = hero

        CellFactory cellfactory = new CellFactory();
        this.board = new Cell[n][n];
        for (int i=0; i<n; i+=1)
            for (int j=0; j<n; j+=1)
            {
                if (this.map[i][j] == 0)
                {
                    Cell barrier = cellfactory.getCell("Barrier", i, j);
                    this.board[i][j] = barrier;
                }
                else if (this.map[i][j] != 0 && this.map[i][j] != 8)
                {
                    Cell regularcell = cellfactory.getCell("RegularCell", i, j);
                    this.board[i][j] = regularcell;
                }
                else if (this.map[i][j] == 8)
                {
                    Cell endpoint = cellfactory.getCell("EndPoint", i, j);
                    this.board[i][j] = endpoint;
                }
            }


        for (int i=0; i<n; i+=1)
            for (int j=0; j<n; j+=1)
            {
                if (this.map[i][j] == 2)
                {
                    Key key = new Key(this.board[i][j]);
                    keyList.add(key);
                }
                else if (this.map[i][j] == 3)
                {
                    Health health = new Health(this.board[i][j]);
                    healthList.add(health);
                }
                else if (this.map[i][j] == 4)
                {
                    Freeze freeze = new Freeze(this.board[i][j]);
                    freezeList.add(freeze);
                }
                else if (this.map[i][j] == 5)
                {
                    HealthBomb healthbomb = new HealthBomb(this.board[i][j]);
                    healthbombList.add(healthbomb);
                }
                else if (this.map[i][j] == 6)
                {
                    ScoreBomb scorebomb = new ScoreBomb(this.board[i][j]);
                    scorebombList.add(scorebomb);
                }
                else if (this.map[i][j] == 7)
                {
                    Enemy enemy = new Enemy(this.board[i][j]);
                    enemyList.add(enemy);
                }
            }
        System.out.println("The board is complete");
        System.out.println("");
    }

    public Cell getHerocell()
    {
        for (int i=0; i<n; i+=1)
            for (int j=0; j<n; j+=1)
            {
                if (this.map[i][j] == 9)
                    return this.board[i][j];
            }
        return null;
    }

    public Cell[][] getCell()
    {
        return this.board;
    }

    public ArrayList<Enemy> getEnemylist()
    {
        return this.enemyList;
    }
}
