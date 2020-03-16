package board;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {
	
	public Key() {
		
	}

	//pretty self explanatory

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == e.VK_LEFT) Player.movingLeft = true;
		if(k == e.VK_RIGHT) Player.movingRight = true;
		if(k == e.VK_UP) Player.movingUp = true;
		if(k == e.VK_DOWN) Player.movingDown = true;
		
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
