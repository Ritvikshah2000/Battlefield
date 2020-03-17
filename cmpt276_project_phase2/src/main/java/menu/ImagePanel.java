package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImagePanel extends JPanel
{
    private Image img;
    public ImagePanel(Image img)
    {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setLayout(null);
    }


    protected void paintComponent(Graphics g)
    {
        Dimension size = this.getParent().getSize();
        g.drawImage(img, 0, 0, size.width, size.height, this);//此方法中的图片大小可随屏幕的改变而改变
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Main Menu");
        ImagePanel panel = new ImagePanel(new ImageIcon("src/main_menu_title.png").getImage());
        frame.setBounds(200, 100, 500, 500);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//让JFrame的关闭按钮起作用
        frame.setVisible(true);//显示JFrame

        // play a new game button
        JButton playnewgame = new JButton("Play a new game");
        Font font = new Font("宋体",Font.BOLD,16);
        playnewgame.setFont(font);
        playnewgame.setBounds(500,300,200,50);
        frame.getContentPane().add(playnewgame);
        playnewgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // launch the game
            }
        });
    }
}
