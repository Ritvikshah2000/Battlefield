package actor;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class Health{
    public static float hp = 89;
    public static ArrayList<HealthBar> bar = new ArrayList<HealthBar>();
    public static int index;
    public static int heartsLeft;

    public Health()
    {
        bar.add(new HealthBar(0, 0));
        bar.add(new HealthBar(32, 0));
        bar.add(new HealthBar(64, 0));   // player has 3 life
    }

    public static void update(Graphics2D g){
        heartsLeft = bar.size();
        index = heartsLeft - 1; // last index
        if (g != null)
            bar.forEach((h) -> h.update(g));
    }
}

