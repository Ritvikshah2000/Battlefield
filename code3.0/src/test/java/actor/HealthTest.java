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
}
