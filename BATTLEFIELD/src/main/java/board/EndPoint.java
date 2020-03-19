package board;

import actor.Player;
import playgame.Main;
import window.GameOverMenu;

public class EndPoint{
    public static final int REQUIREDKEYS = 5;
    public void onHit(){
        if(Player.keyCount >= REQUIREDKEYS){
            Main.getWindow().dispose();
            Main.running = false;
            new GameOverMenu();
        }
    }

}
