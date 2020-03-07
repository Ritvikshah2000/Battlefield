public class Key extends Reward{

    private int score;

    //constructor
    public Key(int x, int y, ID id){
        super(x,y,id);
    }

    //getting methods from reward and overriding them
    
    public void onHit(){
        if(Reward.getId() == ID.Key){
            score += 10;
            System.out.println("You have picked up a key!")
        }
    }

    public void tick(){

    }


}