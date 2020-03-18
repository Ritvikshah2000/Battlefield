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

