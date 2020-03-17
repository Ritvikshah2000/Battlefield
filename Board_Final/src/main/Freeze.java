
import java.awt.*;

public class Freeze extends Reward
{
    private int freezetime = 90;


    public Freeze(int x, int y)
    {
        super(x * 32, y * 32);
    }

    public int getX(){ return (int)(x / 32); };
    public int getY(){ return (int)(y / 32); };

    public void onHit(){
      Main.enemies.forEach((e) -> e.frozenTimer = freezetime);
  		TestLevel.tiles[this.getX()][this.getY()] = new Tile<Void>(1, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), false, null);
      Main.rewards.remove(this);

    }

    public void update(Graphics2D g){
      g.drawImage(Images.testFreeze, x, y, 32, 32, null);
    }


}
