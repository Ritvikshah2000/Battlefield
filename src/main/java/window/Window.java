package window;

import actor.Score;
import playgame.Main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame{

    /**
     * Initializes the main game window according to the size Dimensions
     * @param size Window size parameters as specified by the Dimension object
     * @param main intance of the main game thread
     *
     * @see Dimension
     * @see Main
     */
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
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);

        pack();

        setLocationRelativeTo(null);

        main.start();
    }
}
