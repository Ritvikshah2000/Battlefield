public class RegularCell extends Cell
{
	private Hero hero;
	private ScoreBomb scorebomb;
	private HealthBomb healthbomb;
	private Enemy enemy;
	//private Heart heart;
	//private Key key;
	//private Freeze freeze;

	// Constructor
	public RegularCell(int x, int y)
	{
		super.setPosition(x,y);	
		super.setContents("RegularCell");
		this.hero = null;
		this.scorebomb = null;
		this.healthbomb = null;
		this.enemy = null;	
		/*this.heart = null;
		this.key = null;
		this.freeze = null;*/

		System.out.println("A regular cell has been set in location: (" + x + ", " + y +")");
	}


/*-----------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------Setter, Getter, Remover--------------------------------------------*/

/*-----------------------------------------------------------------------------------------------------------------*/

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

	// Enemy
	public void setEnemy(Enemy enemy)
	{
		this.enemy = enemy;			// we could have enmey overlap
	}

	public Enemy getEnemy()
	{
		return this.enemy;
	}

	public void removeEnemy()
	{
		this.enemy = null;
	}

	// Healthbomb
	public void setHealthbomb(HealthBomb healthbomb)
	{
		if (this.healthbomb == null) { this.healthbomb = healthbomb; }
		else
		{
			System.out.println("Error, healthbomb has been set already");
			System.exit(0);
		}
	}

	public HealthBomb getHealthbomb()
	{
		return this.healthbomb;
	}

	public void removeHealthbomb()
	{
		if (this.healthbomb != null) { this.healthbomb = null; }
		else
		{
			System.out.println("Error, no healthbomb to removed");
			System.exit(0);
		}
	}

	// Scorebomb
	public void setScorebomb(ScoreBomb scorebomb)
	{
		if (this.scorebomb == null) { this.scorebomb = scorebomb; }
		else
		{
			System.out.println("Error, scorebomb has been set already");
			System.exit(0);
		}
	}

	public ScoreBomb getScorebomb()
	{
		return this.scorebomb;
	}

	public void removeScorebomb()
	{
		if (this.scorebomb != null) { this.scorebomb = null; }
		else
		{
			System.out.println("Error, no scorebomb to remove");
			System.exit(0);
		}
	}

	/*// Heart
	public void setHeart(Heart heart)
	{
		if (this.heart == null) { this.heart = heart; }
		else
		{
			System.out.println("Error, heart has been set already");
			System.exit(0);
		}
	}

	public Heart getHeart()
	{
		return this.heart;
	}

	public void removeHeart()
	{
		if (this.heart != null) { this.heart = null; }
		else
		{
			System.out.println("Error, no heart to remove");
			System.exit(0);
		}
	}

	// Key
	public void setKey(Key key)
	{
		if (this.key == null) { this.key = key; }
		else
		{
			System.out.println("Error, key has been set already");
			System.exit(0);
		}
	}

	public Key getKey()
	{
		return this.key;
	}

	public void removeKey()
	{
		if (this.key != null) { this.key = null; }
		else
		{
			System.out.println("Error, no key to remove");
			System.exit(0);
		}
	}

	// Freeze
	public void setFreeze(Freeze freeze)
	{
		if (this.freeze == null) { this.freeze = freeze; }
		else
		{
			System.out.println("Error, freeze has been set already");
			System.exit(0);
		}
	}

	public Freeze getFreeze()
	{
		return this.freeze;
	}

	public void removeFreeze()
	{
		if (this.freeze != null) { this.freeze = null; }
		else
		{
			System.out.println("Error, no freeze to remove");
			System.exit(0);
		}
	}*/

/*-----------------------------------------------------------------------------------------------------------------*/


	public void onHit(Hero hero)
	{
		this.setHero(hero);						// Hero in the regular cell now
		if (this.getEnemy() != null)		// Hero hit a enmey with first priority
		{
			this.enemy.onHit(hero);			// Game over no need to remove enemy
			this.removeEnemy();
		}

		if (this.getHealthbomb() != null)	// Hero hit a Healthbomb, health reduce by one
		{
			this.healthbomb.onHit(hero);
			this.removeHealthbomb();
		}

		if (this.getScorebomb() != null)
		{
			this.scorebomb.onHit(hero);
			this.removeScorebomb();
		}

		/*if (this.getHeart() != null)
		{
			this.heart.onHit(hero);
			this.removeHeart();
		}

		if (this.getKey() != null)
		{
			this.key.onHit(hero);
			this.removeKey();
		}

		if (this.getFreeze() != null)
		{
			this.freeze.onHit(hero);
			this.removeFreeze();
		}*/
	}

	public void onHit(Enemy enemy)
	{
		this.setEnemy(enemy);					// enemy in the regular cell now
											// no need to check if hero in the cell, because we let enemy move first hero move second
	}
}