public class CellFactory    // To create a cell
{
    public Cell getCell(String cell, int x, int y)
    {
        if(cell == null)
        {
            return null;
        }
        if(cell.equalsIgnoreCase("Barrier"))
        {
            return new Barrier(x,y, ID.Barrier);
        }
        else if(cell.equalsIgnoreCase("RegularCell"))
        {
            return new RegularCell(x,y, ID.RegularCell);
        }
        else if(cell.equalsIgnoreCase("EndPoint"))
        {
            return new EndPoint(x,y,ID.EndPoint);
        }
        return null;
    }
}