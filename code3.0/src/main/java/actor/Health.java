package actor;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class Health{
    private static float hp = 89;
    private static ArrayList<HealthBar> bar = new ArrayList<HealthBar>();
    private static int index;
    private static int heartsLeft;

    public Health()
    {
        bar.add(new HealthBar(0, 0));
        bar.add(new HealthBar(32, 0));
        bar.add(new HealthBar(64, 0));   // player has 3 life
    }

    public static float getHp() { return hp; }

    public static ArrayList<HealthBar> getBar() { return bar; }

    public static int getIndex() { return index; }

    public static int getHeartsLeft() { return heartsLeft; }

    public static void increaseHp(float amount) { hp += amount; }

    public static void setHp(float amount) { hp = amount; }

    public static void decreaseHeartLeft() { heartsLeft--; }

    public static void update(Graphics2D g){
            heartsLeft = bar.size();
            index = heartsLeft - 1; // last index
            if (g != null)
                bar.forEach((h) -> h.update(g));
    }
}



