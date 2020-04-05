package board;

import java.awt.Rectangle;
import org.junit.Assert;
import org.junit.Test;

public class TileTest {

    @Test
    public void testTileConstructor(){
        Rectangle rec = new Rectangle(10, 20, 30, 35);
        Tile<Boolean> test = new Tile<>(-1, rec, false, Boolean.FALSE);
        Assert.assertEquals(-1, test.id);
        Assert.assertFalse(test.barrier);
        Assert.assertEquals(Boolean.FALSE, test.item);
        Assert.assertEquals(10, test.x);
        Assert.assertEquals(20, test.y);
        Assert.assertEquals(30, test.width);
        Assert.assertEquals(35, test.height);

    }


    @Test
    public void testGetBounds(){
        Rectangle rec = new Rectangle(10, 20, 30, 30);
        Tile<Boolean> test = new Tile<>(-1, rec, false, Boolean.FALSE);
        Assert.assertEquals(rec.getBounds(), test.getBounds());
    }

    @Test
    public void testHasContents(){
        Tile<Void> testVoid = new Tile<>(-1, new Rectangle(), false, null);
        Tile<Boolean> testItem = new Tile<>(-1, new Rectangle(), false, Boolean.TRUE);
        Assert.assertFalse(testVoid.hasContents());
        Assert.assertTrue(testItem.hasContents());
    }

    @Test
    public void testGetContents(){
        Tile<Void> testVoid = new Tile<>(-1, new Rectangle(), false, null);
        Tile<Boolean> testItem = new Tile<>(-1, new Rectangle(), false, Boolean.TRUE);
        Assert.assertNull(testVoid.getContents());
        Assert.assertEquals(Boolean.TRUE, testItem.getContents());
    }


}
