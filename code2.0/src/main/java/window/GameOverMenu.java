package window;

import actor.Player;
import playgame.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverMenu extends JFrame
{
    public GameOverMenu()
    {
        Main.bgm.stop();

        setTitle("Pause Menu");
        setBounds(500, 200, 500, 500);
        //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.WHITE);
        Container c = getContentPane();
        setLayout(null);
        Font font1 = new Font("宋体",Font.BOLD,32);
        Font font2 = new Font("宋体",Font.BOLD,18);

        // title
        JLabel pause = new JLabel("Game Over");
        pause.setFont(font1);
        pause.setBounds(150, 50, 200, 50);
        c.add(pause);

        JLabel score = new JLabel();
        String finalscore = Integer.toString(Player.score);
        score.setText("Final Score : " + finalscore);
        score.setFont(font2);
        score.setBounds(180, 150, 200, 50);
        c.add(score);

        /*// return to the mainmenu
        JButton mainmenu = new JButton("Return");
        mainmenu.setFont(font2);
        mainmenu.setBounds(140, 200, 200, 50);
        c.add(mainmenu);
        mainmenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainMenu();
            }
        });*/

        // exit
        JButton exit = new JButton("Exit");
        exit.setFont(font2);
        exit.setBounds(140, 200, 200, 50);
        c.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
