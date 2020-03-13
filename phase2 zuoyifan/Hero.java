
public class Hero extends Actor
{
    private int health;
    private int keys;
    private int score;
    //private EndPoint endpoint;

    //Constrctor
    public Hero(Cell regularcell)
    {
        int[] position = regularcell.getPosition();
        this.setPosition(position[0], position[1]);
        this.health = 5;
        this.score = 0;
        this.keys = 0;

        this.setContent(this, regularcell);
        System.out.println("The hero has been set in location: (" + position[0] + ", " + position[1] +")");
    }

    public void setContent(Hero hero, Cell regularcell)
    {
        regularcell.setHero(hero);
    }

    public void removeContent(Cell regularcell)
    {
        regularcell.removeHero();
    }


    /*-----------------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------Setter, Getter, Adder, Reducer--------------------------------------------*/

    /*-----------------------------------------------------------------------------------------------------------------*/

    // Score
    public void addScore(int score)
    {
        this.score += score;
    }

    public void reduceScore(int amount)
    {
        this.score -= amount;
    }

    public int getScore()
    {
        return this.score;
    }

    // Keys
    public void addKeys()
    {
        this.keys += 1;
        this.addScore(50);
    }

    public int getKeys()
    {
        return this.keys;
    }

    // Health
    public void reduceHealth(int amount)
    {
        this.health -= amount;
    }

    public void addHealth(int amount)
    {
        this.health += amount;
    }

    public int getHealth()
    {
        return this.health;
    }

    /*-----------------------------------------------------------------------------------------------------------------*/

    public void doAction(Cell currentcell, Cell nextcell)       // Base on the hero move to the next cell do action.
    {
        int[] cellposition = nextcell.getPosition();
        ID cellid = nextcell.getId();

        if (cellid.equals(ID.RegularCell))
        {
            currentcell.removeHero();
            this.setPosition(cellposition[0], cellposition[1]);
            nextcell.onHit(this);
        }
        else if (cellid.equals(ID.Barrier))
        {
            nextcell.onHit(this);
        }
        else if (cellid.equals(ID.EndPoint))
        {
            currentcell.removeHero();
            this.setPosition(cellposition[0], cellposition[1]);
            nextcell.onHit(this);
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
                this.doAction(board[x_posi][y_posi], board[x_posi][y_posi]);
                break;
        }
    }
}












