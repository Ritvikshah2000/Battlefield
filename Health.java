public class Health extends Reward{

    private int healthValue;
    private int lifeTime;

    //constructor
    public Health(int x, int y, ID id){
        super(x,y, id);
    }

    //getting methods from reward and overriding them
    
    public void onHit(){
        if(Reward.getId() == ID.Health){
            healthValue++;
            System.out.println("You gained a heart!") 
        }
    }

    public void decLifeTime(){
    
    }

    public void tick(){

    }


}