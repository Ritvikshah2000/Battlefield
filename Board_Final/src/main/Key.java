//package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.util.*;

public class Key implements KeyListener {

<<<<<<< HEAD
    public Key() {

    }

    //pretty self explanatory

    public void keyPressed(KeyEvent e) {
        if (!Main.pause) {
            int k = e.getKeyCode();

            if (k == e.VK_LEFT) Player.movingLeft = true;
            if (k == e.VK_RIGHT) Player.movingRight = true;
            if (k == e.VK_UP) Player.movingUp = true;
            if (k == e.VK_DOWN) Player.movingDown = true;
            if (k == e.VK_P) {
                new PauseMenu();
            }
        }
    }


    public void keyReleased(KeyEvent e) {
        if (!Main.pause) {
            int k = e.getKeyCode();

            if (k == e.VK_LEFT) Player.movingLeft = false;
            if (k == e.VK_RIGHT) Player.movingRight = false;
            if (k == e.VK_UP) Player.movingUp = false;
            if (k == e.VK_DOWN) Player.movingDown = false;
        }
    }


    public void keyTyped(KeyEvent e) {}
=======

	public Key() {

	}

	//pretty self explanatory

	public void keyPressed(KeyEvent e) {
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
>>>>>>> 9e71ed87c99fe336f79dcf3d235c1347eec2d5aa
