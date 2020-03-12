//this class is a skeleton class for all rewards
public abstract class Reward{

    // attributes
    protected int value;
    protected int x, y;
    protected ID id; //from the enum class

    //constructor (would be overriden)
    public Reward(int x, int y, ID id){
        this.x = x;                             
        this.y = y;
        this.id = id
    }

    //in order to update the rewards:
    public abstract void tick();


    //hit
    public void onHit(Hero hero){
        
    }

    //getters and setters
    public ID getId(){

    }
    public void setId(ID id){

    }
    public int getX(){

    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){

    }
    public void setY(int y){
        this.y = y;
    }


}