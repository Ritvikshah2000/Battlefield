package cell;

import actor.Direction;
import actor.Enemy;
import actor.Hero;
import hazard.HealthBomb;
import hazard.ScoreBomb;
import reward.Freeze;
import reward.Health;
import reward.Key;


public abstract class Cell {
    //attributes
    private int[] position;                // position[0] = x, position[1] = y
    private ID id;

    //Position
    public void setPosition(int x, int y)
    {
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
    }

    public int[] getPosition()
    {
        return this.position;
    }

    public void setId(ID id)
    {
        this.id = id;
    }

    public ID getId()
    {
        return this.id;
    }

    // onHit
    public void onHit(Hero hero) {}
    public void onHit(Enemy enemy) {}

    public void setHero(Hero hero) {}
    public Hero getHero() { return null; }
    public void removeHero() {}

    public void setEnemy(Enemy enemy) {}
    public Enemy getEnemy() { return null; }
    public void removeEnemy() {}

    public void setHealthbomb(HealthBomb healthbomb) {}
    public HealthBomb getHealthbomb()
    {
        return null;
    }
    public void removeHealthbomb() {}

    public void setScorebomb(ScoreBomb scorebomb) {}
    public ScoreBomb getScorebomb()
    {
        return null;
    }
    public void removeScorebomb() {}

    public void setKey(Key key) {}
    public Key getKey() { return null; }
    public void removeKey() {}

    public void setHealth(Health health) {}
    public Health getHealth() { return null; }
    public void removeHealth() {}

    public void setFreeze(Freeze freeze) {}
    public Freeze getFreeze() { return null; }
    public void removeFreeze() {}

    public void printcell() {}
}
