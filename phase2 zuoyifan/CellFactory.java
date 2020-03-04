public class CellFactory		// To create a cell
{
	public Cell getCell(String cell, int x, int y)
	{
		if(cell == null)
		{
        	return null;
      	}        
      	if(cell.equalsIgnoreCase("Barrier"))
      	{
        	return new Barrier(x,y);
      	} 
      	else if(cell.equalsIgnoreCase("RegularCell"))
      	{
        	return new RegularCell(x,y);
      	} 
      	else if(cell.equalsIgnoreCase("EndPoint"))
      	{
        	return new EndPoint(x,y);
      	}
      	return null;
	}
}