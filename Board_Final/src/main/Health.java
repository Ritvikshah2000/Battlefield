import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class Health{
  public static int hp = 89;
  public static ArrayList<HealthBar> bar = new ArrayList<HealthBar>();
  public static int index;
  public static int heartsLeft;

  public static void update(Graphics2D g){
    heartsLeft = bar.size();
    index = heartsLeft - 1;
    //g.setColor(Color.pink);
    //g.fillRect(25, 25, hp*2, 50);
    bar.forEach((h) -> h.update(g));
  }
}
