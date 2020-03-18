package window;

import actor.Score;
import playgame.Key;
import playgame.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class Window extends JFrame{


    //all general window details
    public Window(Dimension size, Main main) {
        main.setPreferredSize(size);
        main.setMinimumSize(size);
        main.setMaximumSize(size);

        JPanel panel = Score.getPanel();
        this.setTitle("game");

        this.setVisible(true);
        this.setLayout(new BorderLayout());
        //frame.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        this.add(main, BorderLayout.CENTER);
        this.add(panel);
        this.addKeyListener(new Key());

        this.pack();

        this.setLocationRelativeTo(null);

        if(main.mainThread == null)
            main.start();
        else
        {
            main.mainThread.stop();
            main.start();
        }
    }
}
