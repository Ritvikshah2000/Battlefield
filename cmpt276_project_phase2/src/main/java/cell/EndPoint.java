package cell;

import actor.Enemy;
import actor.Hero;
import game.GameOver;

public class EndPoint extends Cell
{
    private Hero hero;

    public EndPoint() { this.hero = null; }

    // Constructor
    public EndPoint(int x, int y, ID id)
    {
        super.setPosition(x,y);
        super.setId(id);
        this.hero = null;
        System.out.println("The end point has been set in location: (" + x + ", " + y +")");
    }

    // Hero
    public void setHero(Hero hero)
    {
        if (this.hero == null)
        {
            this.hero = hero;
        }
        else
        {
            System.out.println("Error, hero has been set already");
            System.exit(0);
        }
    }

    public Hero getHero()
    {
        return this.hero;
    }

    public void removeHero()
    {
        if (this.hero != null) { this.hero = null; }
        else
        {
            System.out.println("Error, no hero to removed");
            System.exit(0);
        }
    }

    public void onHit(Hero hero)
    {
        this.setHero(hero);
        GameOver gameover = new GameOver(hero, this);
        System.out.println("You have't collect all keys");
    }

    public void onHit(Enemy enemy)
    {
        System.out.println("Enemy cannot go through end point");
    }

    public void printcell() {System.out.println("This is a end point");}
}
