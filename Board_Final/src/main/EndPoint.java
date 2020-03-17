


public class EndPoint{
  public static final int REQUIREDKEYS = 10;
  public void onHit(){
    if(Player.keyCount == REQUIREDKEYS){
      System.out.println("The player finished the level");
      System.exit(0);
    }
  }

}
