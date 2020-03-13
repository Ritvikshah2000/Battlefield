package actor;

import cell.Cell;
import content.Cellcontent;

public abstract class Actor implements Cellcontent
{
    private int[] position;

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
    public void removeContent(Object content, Cell regularcell) {}

    public void doAction(Cell currentcell, Cell nextcell) {}

    public void Move(Cell[][] board, Direction d) {}
}
