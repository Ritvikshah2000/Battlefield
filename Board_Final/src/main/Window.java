//package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
//all general window details
	public Window(Dimension size, Main main) {
		main.setPreferredSize(size);
		main.setMinimumSize(size);
		main.setMaximumSize(size);

		JFrame frame = new JFrame("Game");

		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		frame.add(main, BorderLayout.CENTER);
		//frame.addKeyListener(new Key());

		frame.pack();

		frame.setLocationRelativeTo(null);

		main.start();
	}
}
