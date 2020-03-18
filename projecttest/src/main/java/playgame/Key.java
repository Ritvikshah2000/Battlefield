package playgame;

import actor.Player;
import window.PauseMenu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {

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
}

