


public class EndPoint{

  public void onHit(){
    if(Player.keyCount == 10){
      System.out.println("The player finished the level");
      System.exit(0);
    }
  }

}
