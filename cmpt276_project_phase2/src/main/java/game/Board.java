package game;

import actor.Enemy;
import cell.Cell;
import cell.CellFactory;
import hazard.HealthBomb;
import hazard.ScoreBomb;
import reward.Freeze;
import reward.Health;
import reward.Key;

public class Board
{
    private Cell[][] board;
    private Enemy[] enemylist;
    private int n = 10;

    public Board()
    {
        int n = 10;     // n is size of the matrix

        /*-----------------------------Board-----------------------------*/

        // 0 = barrier, 1 = regularcell, 2 = endpoint
        int[][] map = { {0,0,0,0,0,0,0,0,0,0},
                {0,2,1,1,1,1,1,1,1,0},
                {0,1,1,0,0,1,1,0,1,0},
                {0,1,1,1,1,1,1,0,1,0},
                {0,0,0,1,1,1,1,1,1,0},
                {0,1,1,1,1,1,1,1,1,0},
                {0,1,1,1,0,0,0,1,1,0},
                {0,1,1,1,1,1,1,1,1,0},
                {0,1,1,1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0,0,0,0} };

        CellFactory cellfactory = new CellFactory();
        this.board = new Cell[n][n];
        for (int i=0; i<n; i+=1)
            for (int j=0; j<n; j+=1)
            {
                if (map[i][j] == 0)
                {
                    Cell barrier = cellfactory.getCell("Barrier", i, j);
                    this.board[i][j] = barrier;
                }
                else if (map[i][j] == 1)
                {
                    Cell regularcell = cellfactory.getCell("RegularCell", i, j);
                    this.board[i][j] = regularcell;
                }
                else if (map[i][j] == 2)
                {
                    Cell endpoint = cellfactory.getCell("EndPoint", i, j);
                    this.board[i][j] = endpoint;
                }
            }

        /*---------------------------Startpoint---------------------------*/

        //this.hero = new Hero(this.board[n-2][n-2]);

        /*-----------------------------Reward----------------------------*/

        //Key
        Key key1 = new Key(this.board[1][4]);
        Key key2 = new Key(this.board[5][5]);
        Key key3 = new Key(this.board[8][1]);
        Key key4 = new Key(this.board[8][6]);
        Key key5 = new Key(this.board[1][8]);

        //Health
        Health health1 = new Health(this.board[7][1]);

        //Freeze
        Freeze freeze1 = new Freeze(this.board[4][4]);

        /*-----------------------------Hazard----------------------------*/

        //Healthbomb
        HealthBomb healthbomb1 = new HealthBomb(this.board[6][2]);
        HealthBomb healthbomb2 = new HealthBomb(this.board[5][7]);

        //Scorebomb
        ScoreBomb scorebomb1 = new ScoreBomb(this.board[8][8]);
        ScoreBomb scorebomb2 = new ScoreBomb(this.board[1][2]);

        /*-----------------------------Enemy----------------------------*/

        Enemy enemy1 = new Enemy(this.board[8][2]);
        Enemy enemy2 = new Enemy(this.board[2][1]);
        Enemy enemy3 = new Enemy(this.board[1][6]);
        enemylist = new Enemy[3];
        enemylist[0] = enemy1;
        enemylist[1] = enemy2;
        enemylist[2] = enemy3;

        System.out.println("The board is complete");
        System.out.println("");
    }

    public Cell getHerocell()
    {
        return board[n-2][n-2];
    }

    public Cell[][] getCell()
    {
        return this.board;
    }

    public Enemy[] getEnemylist()
    {
        return this.enemylist;
    }


}
