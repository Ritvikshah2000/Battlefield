public class demo
{
	public static void main(String[] args)
	{
		CellFactory cellfactory = new CellFactory();
		Cell cell1 = cellfactory.getCell("Barrier", 3, 4);
		Cell cell2 = cellfactory.getCell("RegularCell", 1, 2);
		Cell cell3 = cellfactory.getCell("EndPoint", 5, 6);
		System.out.println("In cell1 is a " + cell1.getContents());
		System.out.println("In cell2 is a " + cell2.getContents());
		System.out.println("In cell1 is a " + cell3.getContents());
	}
}