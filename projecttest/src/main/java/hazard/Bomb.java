package hazard;

import java.awt.Graphics2D;

public abstract class Bomb {

    int x, y, index;

    Bomb(int x, int y) {
        this.x =x;
        this.y =y;
    }

    public abstract void onHit();

    public abstract void update(Graphics2D g);

}

