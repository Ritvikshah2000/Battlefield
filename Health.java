public class Health extends Reward{

    private int healthValue;
    private int lifeTime;

    //constructor
    public Health(int x, int y, ID id){
        super(x,y, id);
    }

    //getting methods from reward and overriding them
    
    public void onHit(){
        if(hero.getHealth() == 0){
            System.out.println("You have died!");
        }else{
            reduceHealth();
        }
    }

    public void decLifeTime(){
    
    }

    public void tick(){

    }


}