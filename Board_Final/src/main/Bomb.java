
import java.awt.Graphics2D;

public abstract class Bomb {

	int x, y, index;

	Bomb(int x, int y) {
		this.x =x;
		this.y =y;
	}

	public int getX(){ return x / 32; };
	public int getY(){ return y / 32; };
	
	public abstract void onHit();

	public abstract void update(Graphics2D g);

}
