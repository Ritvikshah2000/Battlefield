import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Shape;

public class Hero{

  private int[] position;
  private int health;
  private Shape shape;
  private final int SIZE = 10;

  public Hero(){
    position = new int[2];
    position[0] = 0;
    position[1] = 0;
    health = 10;
    shape = new Rectangle2D.Double(position[0] + 30, position[1] + 30, SIZE, SIZE);
  }

  public Hero(int x, int y){
      position = new int[2];
      position[0] = x;
      position[1] = y;
      health = 10;
      shape = new Rectangle2D.Double(position[0] + 25, position[1] + 25, SIZE, SIZE);
  }

  public void move(KeyEvent e){
    AffineTransform t = new AffineTransform();
    int code = e.getKeyCode();
    switch(code){
      case KeyEvent.VK_DOWN:
        position[1] += 30;
        t.translate(0, 30);
        System.out.println("DOWN KEY CODE RECEIVED");
        break;
      case KeyEvent.VK_UP:
        position[1] -= 30;
        t.translate(0, -30);
        break;
      case KeyEvent.VK_RIGHT:
        position[0] += 30;
        t.translate(30, 0);
        break;
      case KeyEvent.VK_LEFT:
        position[0] -= 30;
        t.translate(-30, 0);
        break;
    }
    shape = t.createTransformedShape(shape);
    System.out.println("Shape transformed");
  }

  public Shape getShape(){
    return shape;
  }

}
