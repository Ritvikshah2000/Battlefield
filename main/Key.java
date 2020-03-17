package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.util.*;

public class Key implements KeyListener {


	public Key() {

	}

	//pretty self explanatory

	public void keyPressed(KeyEvent e) {
		System.out.println("Key Press");
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_ESCAPE){
			System.out.println("Program Exited by User");
			System.exit(0);
		}

		if(id == e.VK_LEFT) Player.movingLeft = true;
		if(id == e.VK_RIGHT) Player.movingRight = true;
		if(id == e.VK_UP) Player.movingUp = true;
		if(id == e.VK_DOWN) Player.movingDown = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();

		if(k == e.VK_LEFT) Player.movingLeft = false;
		if(k == e.VK_RIGHT) Player.movingRight = false;
		if(k == e.VK_UP) Player.movingUp = false;
		if(k == e.VK_DOWN) Player.movingDown = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}
