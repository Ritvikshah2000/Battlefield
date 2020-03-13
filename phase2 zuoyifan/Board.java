public class Board
{
    private Cell[][] board;
    public Hero hero;

    public Board()
    {
        int n = 10;     // n is size of the matrix

        /*--------------------------Boundry-------------------------------*/

        CellFactory cellfactory = new CellFactory();
        this.board = new Cell[n][n];
        for (int i=0; i<n-1; i+=1)
        {
            Cell barrier = cellfactory.getCell("Barrier", 0, i);
            this.board[0][i] = barrier;
        }
        for (int i=1; i<n; i+=1)
        {
            Cell barrier = cellfactory.getCell("Barrier", i, 0);
            this.board[i][0] = barrier;
        }
        for (int i=1; i<n; i+=1)
        {
            Cell barrier = cellfactory.getCell("Barrier", n-1, i);
            this.board[n-1][i] = barrier;
        }
        for (int i=0; i<n-1; i+=1)
        {
            Cell barrier = cellfactory.getCell("Barrier", i, n-1);
            this.board[i][n-1] = barrier;
        }

        /*---------------------------Regularcell--------------------------*/

        for (int i=1; i<n-1; i+=1)
        {
            for (int j=1; j<n-1; j+=1)
            {
                Cell regularcell = cellfactory.getCell("RegularCell", i, j);
                this.board[i][j] = regularcell;
            }
        }

        /*----------------------------Endpoint----------------------------*/        //end point is always board[1][1]

        Cell endpoint = cellfactory.getCell("EndPoint", 1, 1);
        this.board[1][1] = endpoint;

        /*---------------------------Startpoint---------------------------*/

        this.hero = new Hero(this.board[n-2][n-2]);

        /*-----------------------------Barrier----------------------------*/

        Cell barrier1 = cellfactory.getCell("Barrier", 2,3 );
        Cell barrier2 = cellfactory.getCell("Barrier", 2,4 );
        Cell barrier3 = cellfactory.getCell("Barrier", 2,7 );
        Cell barrier4 = cellfactory.getCell("Barrier", 3,7 );
        Cell barrier5 = cellfactory.getCell("Barrier", 4,1 );
        Cell barrier6 = cellfactory.getCell("Barrier", 4,2 );
        Cell barrier7 = cellfactory.getCell("Barrier", 6,4 );
        Cell barrier8 = cellfactory.getCell("Barrier", 6,5 );
        Cell barrier9 = cellfactory.getCell("Barrier", 6,6 );
        this.board[2][3] = barrier1;
        this.board[2][4] = barrier2;
        this.board[2][7] = barrier3;
        this.board[3][7] = barrier4;
        this.board[4][1] = barrier5;
        this.board[4][2] = barrier6;
        this.board[6][4] = barrier7;
        this.board[6][5] = barrier8;
        this.board[6][6] = barrier9;

        /*-----------------------------Reward----------------------------*/

        //Key
        Key key1 = new Key(this.board[1][4]);
        Key key2 = new Key(this.board[5][5]);
        Key key3 = new Key(this.board[8][1]);
        Key key4 = new Key(this.board[8][5]);
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
    }

    public void moveHero(Direction d)
    {
        this.hero.Move(this.board, d);
    }
}