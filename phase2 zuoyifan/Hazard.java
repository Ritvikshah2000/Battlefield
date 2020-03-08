public class Hazard 
{
	private int[] position;
	private String contents;
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

	// Contents
	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public String getContents()
	{
		return this.contents;
	}

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