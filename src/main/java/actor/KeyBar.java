package actor;

import reward.KeyReward;

import java.util.ArrayList;
import java.awt.Graphics2D;


public class KeyBar{
    private static ArrayList<KeyReward> kBar = new ArrayList<KeyReward>();
    private static int collected = 0;

    /**
     * Returns list of collected KeyReward instances
     * @return an ArrayList of collected KeyReward instances
     * @see KeyReward
     */
    public static ArrayList<KeyReward> getKbar() { return kBar; }

    /**
     * Increment the number of KeyRewards collected
     * @return an int value of KeyRewards collected
     */
    public static int increaseCollected() {
        collected++;
        return collected;
    }

    /**
     * Redraws the KeyBar graphics
     * @param g Graphics2D instance used to redraw graphics
     * @see Graphics2D
     */
    public static void update(final Graphics2D g){
        kBar.forEach((k) -> k.update(g));
    }
}


