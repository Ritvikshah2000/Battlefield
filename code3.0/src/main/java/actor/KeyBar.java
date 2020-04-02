package actor;

import reward.KeyReward;

import java.util.ArrayList;
import java.awt.Graphics2D;


public class KeyBar{
    public static ArrayList<KeyReward> kBar = new ArrayList<KeyReward>();
    public static int collected = 0;

    public static void update(Graphics2D g){
        kBar.forEach((k) -> k.update(g));
    }
}


