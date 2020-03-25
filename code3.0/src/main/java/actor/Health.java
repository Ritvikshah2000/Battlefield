package actor;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class Health{
    public static float hp = 89;
    public static ArrayList<HealthBar> bar = new ArrayList<HealthBar>();
    public static int index;
    public static int heartsLeft;

    public static void update(Graphics2D g){
        heartsLeft = bar.size();
        index = heartsLeft - 1;
        bar.forEach((h) -> h.update(g));
    }
}



