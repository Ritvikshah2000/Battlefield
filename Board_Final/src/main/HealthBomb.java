import java.awt.Graphics2D;
import java.awt.Rectangle;

public class HealthBomb extends Bomb {

	public int healthDamage = 10;

	HealthBomb(int x, int y) {
		super(x * 32, y * 32);
	}

	public int getX(){ return x / 32; };
	public int getY(){ return y / 32; };

	@Override
	public void onHit() {
		Health.bar.remove(Health.index);//health minus
		TestLevel.tiles[this.getX()][this.getY()] = new Tile<Void>(1, new Rectangle( x * (Tile.TILESIZE/2), y * (Tile.TILESIZE/2), Tile.TILESIZE/2, Tile.TILESIZE/2), false, null);
		Main.bombs.remove(this);

		/*	g.drawImage(Images.testBomb3, x,y,32,32,null);   //IGNORE!!
			g.drawImage(Images.testBomb4, x,y,32,32,null);

			for(int i=0;i<1000;i++)
			g.drawImage(Images.testBomb2, x,y,32,32,null);
			g.drawImage(Images.tiles[0], x,y,32,32 ,null);*/
		}

	@Override
	public void update(Graphics2D g){
		g.drawImage(Images.testBomb, x, y, 32, 32, null);
	}

}
