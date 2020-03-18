package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
//all general window details
	public Window(Dimension size, Main main) {
		main.setPreferredSize(size);
		main.setMinimumSize(size);
		main.setMaximumSize(size);

		JFrame frame = new JFrame("Game");
		JPanel panel = Score.getPanel();

		panel.setLayout(new BorderLayout());
		panel.add(main, BorderLayout.CENTER);
		panel.add(Score.getComponent(), BorderLayout.NORTH);

		frame.setVisible(true);
		//frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


		//frame.add(Score.getPanel().add(Score.getComponent()));
		//frame.add(main, BorderLayout.CENTER);
		//frame.addKeyListener(new Key());
		frame.add(panel);

		frame.pack();

		frame.setLocationRelativeTo(null);

		main.start();
	}
}
