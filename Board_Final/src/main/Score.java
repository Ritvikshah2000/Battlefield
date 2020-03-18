<<<<<<< HEAD
package main;
=======

>>>>>>> 9e71ed87c99fe336f79dcf3d235c1347eec2d5aa
import java.awt.*;
import javax.swing.*;

public class Score{
  private static JLabel textView = new JLabel("000", JLabel.CENTER);
  private static JPanel displayPanel = new JPanel();

  public static JPanel getPanel(){
    return displayPanel;
  }

  public static JLabel getComponent(){
    return textView;
  }

  public static void update(){
    textView.setText("" + Player.score);
  }
}
