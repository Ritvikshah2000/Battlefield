package window;

import playgame.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapChoice extends JFrame
{

    public MapChoice()
    {
        setTitle("Map Choice");
        setBounds(500, 200, 500, 500);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        Container c = getContentPane();
        Font font2 = new Font("宋体",Font.BOLD,18);

        // map 1
        JButton map1 = new JButton("map 1");
        map1.setFont(font2);
        //map1.setBounds(150,100,200,50);
        c.add(map1, BorderLayout.WEST);
        map1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new Main(1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // map 1
        JButton map2 = new JButton("map 2");
        map2.setFont(font2);
        //map2.setBounds(150,400,200,50);
        c.add(map2, BorderLayout.EAST);
        map2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new Main(2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // exit
        JButton exit = new JButton("Exit");
        exit.setFont(font2);
        c.add(exit, BorderLayout.CENTER);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
