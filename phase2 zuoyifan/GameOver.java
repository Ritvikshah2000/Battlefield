
public class GameOver
{
    public GameOver(Hero hero, EndPoint endpoint)
    {
        if (hero.getHealth() <= 0)
        {
            System.out.println("Game over, you lose, your health reduce to zero!");
            System.out.println("Your score: " + hero.getScore());
            System.exit(0);
        }
        else if (hero.getScore() <= 0)
        {
            System.out.println("Game over, you lose, your score reduce to zero!");
            System.out.println("Your score: " + hero.getScore());
            System.exit(0);
        }
        else if (hero.getKeys() == 5 && endpoint.getHero() != null)
        {
            System.out.println("Game over, you win!");
            System.out.println("Your score: " + hero.getScore());
            System.exit(0);
        }
        else
        {
            /* game is not over yet */
        }
    }
}