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
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        Container c = getContentPane();
        Font font1 = new Font("宋体",Font.BOLD,32);
        Font font2 = new Font("宋体",Font.BOLD,18);

        // Battle Field
        JLabel l = new JLabel("BATTLE FIELD");
        l.setFont(font1);
        l.setBounds(140, 50, 250, 50);
        c.add(l);

        // play a new game button
        JButton playnewgame = new JButton("Play a new game");
        playnewgame.setFont(font2);
        playnewgame.setBounds(150,130,200,50);
        c.add(playnewgame);
        playnewgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // launch the game
            }
        });

        // record
        JLabel record = new JLabel("Record: 0");
        record.setFont(font2);
        record.setBounds(200, 200, 200, 50);
        //String newrecord = "0";                                     //renew the higest score
        //record.setText(newrecord);
        c.add(record);

        // exit
        JButton exit = new JButton("Exit");
        exit.setFont(font2);
        exit.setBounds(150,260,200,50);
        c.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /*JLabel picture = new JLabel();
        Icon icon = new ImageIcon("src/main_menu_title.png");
        picture.setIcon(icon);
        picture.setBounds(0,0, 200, 50);
        //picture.setLocation(100, 100);
        c.add(picture);*/
    }

    public static void main(String[] args)
    {
        new MainMenu();
    }
}
