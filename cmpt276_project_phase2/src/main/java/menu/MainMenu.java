package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame
{
    public MainMenu()
    {
        setTitle("Main Menu");
        setBounds(500, 200, 500, 500);
        //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        Container c = getContentPane();

        // play a new game button
        JButton playnewgame = new JButton("Play a new game");
        Font font = new Font("宋体",Font.BOLD,16);
        playnewgame.setFont(font);
        playnewgame.setBounds(150,220,200,50);
        c.add(playnewgame);
        playnewgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // launch the game
            }
        });

        // record
        JLabel record = new JLabel("Record: 0");
        record.setFont(font);
        record.setBounds(210, 280, 200, 50);
        String newrecord = "0";                                     //renew the higest score
        record.setText(newrecord);
        c.add(record);

        // exit
        JButton exit = new JButton("Exit");
        exit.setFont(font);
        exit.setBounds(150,340,200,50);
        c.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel picture = new JLabel("main menu");
        Icon icon = new ImageIcon("src/main_menu_title.png");
        picture.setIcon(icon);
        picture.setBounds(10,10,50,50);
        c.add(picture);
    }

    public static void main(String[] args)
    {
        new MainMenu();
    }
}
