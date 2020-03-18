


public class EndPoint{
  public static final int REQUIREDKEYS = 5;
  public void onHit(){
    if(Player.keyCount == REQUIREDKEYS){
      System.out.println("The player finished the level");
      System.exit(0);
    }
  }

}
