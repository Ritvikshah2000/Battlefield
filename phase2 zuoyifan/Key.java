
public class Key extends Reward
{
    private int key;

    //constructor
    public Key(Cell regularcell)
    {
        int[] position = regularcell.getPosition();
        super.setPosition(position[0], position[1]);
        this.key = 1;

        this.setContent(this, regularcell);
        System.out.println("The key has been set in location: (" + position[0] + ", " + position[1] +")");
    }

    public void setContent(Key key, Cell regularcell)
    {
        regularcell.setKey(key);
    }

    public void removeContent(Cell regularcell)
    {
        regularcell.removeKey();
    }

    public void onHit(Hero hero)
    {
        hero.addKeys();
        System.out.println("You got a Key");
    }

    public void tick()
    {

    }


}