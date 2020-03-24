package board;

import actor.Player;
import music.Winning;
import playgame.Main;
import window.GameOverMenu;

public class EndPoint{
    public static final int REQUIREDKEYS = 5;
    public Winning winsound;

    public void onHit(){
        if(Player.keyCount >= REQUIREDKEYS){
            Main.getWindow().dispose();
            Main.running = false;
            this.winsound = new Winning();
            new GameOverMenu();
        }
    }

}
