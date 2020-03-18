<<<<<<< HEAD
package main;


public class EndPoint{
    public static final int REQUIREDKEYS = 5;
    public void onHit(Main main){
        if(Player.keyCount >= REQUIREDKEYS){
            Main.getWindow().dispose();
            main.running = false;
            new GameOverMenu();
        }
    }

}

=======



public class EndPoint{
  public static final int REQUIREDKEYS = 5;
  public void onHit(){
    if(Player.keyCount == REQUIREDKEYS){
      System.out.println("The player finished the level");
      System.exit(0);
    }
  }

}
>>>>>>> 9e71ed87c99fe336f79dcf3d235c1347eec2d5aa
