package actor;

import actor.Health;
import actor.HealthBar;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;

public class HealthTest {

    @Test
    public void testHealthConstructor()
    {
        Health health = new Health();
        Assert.assertEquals(3, health.getBar().size());
    }

    /*@Test
    public void testUpdateHealth()
    {
        Health health = new Health();
        health.update(null);
        Assert.assertEquals(3, health.bar.size());
        Assert.assertEquals(3, health.heartsLeft);
        Assert.assertEquals(2, health.index);

        health.hp += 30;
        health.bar.add(new HealthBar((32 * health.heartsLeft), 0));
        health.update(null);
        Assert.assertEquals(4, health.heartsLeft);
        Assert.assertEquals(3, health.index);

        health.hp -= 30;
        health.bar.remove(health.index);
        health.update(null);
        Assert.assertEquals(3, health.heartsLeft);
        Assert.assertEquals(2, health.index);
    }*/
}
