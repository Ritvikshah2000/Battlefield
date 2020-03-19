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

        new JFrame("Game");
        JPanel panel = Score.getPanel();

        panel.setLayout(new BorderLayout());
        panel.add(main, BorderLayout.CENTER);
        panel.add(Score.getComponent(), BorderLayout.NORTH);

        setVisible(true);
        //frame.setLayout(new BorderLayout());
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //frame.add(Score.getPanel().add(Score.getComponent()));
        //frame.add(main, BorderLayout.CENTER);
        //frame.addKeyListener(new Key());
        add(panel);

        pack();

        setLocationRelativeTo(null);

        main.start();
    }
}