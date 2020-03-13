
public class Health extends Reward{
    private int health;
    private int lifeTime;

    //constructor
    public Health(Cell regularcell)
    {
        int[] position = regularcell.getPosition();
        super.setPosition(position[0], position[1]);
        this.health = 1;

        this.setContent(this, regularcell);
        System.out.println("The health has been set in location: (" + position[0] + ", " + position[1] +")");
    }

    //getting methods from reward and overriding them

    public void onHit(Hero hero)
    {
        hero.addHealth(this.health);
        System.out.println("You gained a heart!");
    }

    public void setContent(Health health, Cell regularcell)
    {
        regularcell.setHealth(health);
    }

    public void removeContent(Cell regularcell)
    {
        regularcell.removeHealth();
    }

    public void decLifeTime(){

    }

    public void tick(){

    }
}