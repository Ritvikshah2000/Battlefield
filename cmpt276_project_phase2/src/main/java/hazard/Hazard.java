package hazard;

import cell.Cell;
import content.Cellcontent;
import actor.Hero;
import game.GameOver;
import cell.EndPoint;

public abstract class Hazard implements Cellcontent
{
    private int[] position;
    protected int HealthReduceValue;
    protected int ScoreReduceValue;


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

    public void setContent(Object content, Cell regularcell) {}
    public void removeContent(Cell regularcell) {}

    public int getHealthReduceValue()
    {
        return this.HealthReduceValue;
    }

    public int getScoreReduceValue()
    {
        return this.ScoreReduceValue;
    }

    public void onHit(Hero hero)
    {
        hero.reduceScore(getScoreReduceValue());
        hero.reduceHealth(getHealthReduceValue());
        GameOver gameover = new GameOver(hero, new EndPoint());
    }
}
