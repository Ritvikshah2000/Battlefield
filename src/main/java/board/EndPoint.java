package board;

import actor.Player;
import music.Winning;
import playgame.Main;
import window.GameOverMenu;

public class EndPoint{

    private static final int REQUIRED_KEYS = 5;

    public void onHit(){
        if(Player.getKeyCount() >= REQUIRED_KEYS){
            Main.getWindow().dispose();
            Main.setRunning(false);
            new Winning();
            new GameOverMenu();
        }
    }

    public static int getRequiredKeys(){ return REQUIRED_KEYS; }

}
