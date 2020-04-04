package board;

import actor.Player;
import org.junit.Assert;
import org.junit.Test;
import playgame.Main;

public class EndPointTest {

    @Test
    public void testOnHit(){
        new Main(1);
        EndPoint test = new EndPoint();
        Player.keyCount = 0;
        test.onHit();
        Assert.assertTrue(Main.running);
        Player.keyCount = 5;
        test.onHit();
        Assert.assertFalse(Main.running);
    }
}
