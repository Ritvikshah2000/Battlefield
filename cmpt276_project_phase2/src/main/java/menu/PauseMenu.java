package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseMenu extends JFrame
{
    public PauseMenu()
    {
        setTitle("Pause Menu");
        setBounds(500, 200, 500, 500);
        //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        Font font1 = new Font("宋体",Font.BOLD,32);
        Font font2 = new Font("宋体",Font.BOLD,18);

        // title
        JLabel pause = new JLabel("Pause Menu");
        pause.setFont(font1);
        pause.setBounds(150, 50, 200, 50);
        c.add(pause);

        // resume
        JButton resume = new JButton("Resume");
        resume.setFont(font2);
        resume.setBounds(150,150,200,50);
        c.add(resume);
        resume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                // resume the game
            }
        });

        // restart
        final JButton restart = new JButton("restart");
        restart.setFont(font2);
        restart.setBounds(150, 230, 200, 50);
        c.add(restart);
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                // restart the game
            }
        });

        // exit
        JButton exit = new JButton("Exit");
        exit.setFont(font2);
        exit.setBounds(200,300,100,50);
        c.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args)
    {
        new PauseMenu();
    }
}
