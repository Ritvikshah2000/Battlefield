package actor;

import reward.KeyReward;

import java.util.ArrayList;
import java.awt.Graphics2D;


public class KeyBar{
    private static ArrayList<KeyReward> kBar = new ArrayList<KeyReward>();
    private static int collected = 0;

    public static ArrayList<KeyReward> getKbar() { return kBar; }

    public static int increaseCollected() {
        collected++;
        return collected;
    }

    public static void update(Graphics2D g){
        kBar.forEach((k) -> k.update(g));
    }
}


