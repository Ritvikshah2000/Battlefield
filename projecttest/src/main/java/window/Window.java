package window;

import playgame.Key;
import playgame.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{


    //all general window details
    public Window(Dimension size, Main main) {
        main.setPreferredSize(size);
        main.setMinimumSize(size);
        main.setMaximumSize(size);

        //JFrame frame = new JFrame("Game");
        this.setTitle("game");

        this.setVisible(true);
        this.setLayout(new BorderLayout());
        //frame.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        this.add(main, BorderLayout.CENTER);
        this.addKeyListener(new Key());

        this.pack();

        this.setLocationRelativeTo(null);

        main.start();
    }
}
