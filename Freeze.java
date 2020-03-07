public class Freeze extends Reward{

    private int duration;

    //constructor
    public Freeze(int x, int y, ID id){
        super(x,y, id);
    }

    //getting methods from reward and overriding them
    
    public void onHit(){
        if(Reward.getId() == ID.Freeze){
            duration = 10;
            System.out.println("The enemies have been frozen for 10 seconds!")
        }
    }

    public void tick(){

    }


}