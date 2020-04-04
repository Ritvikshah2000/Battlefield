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
        if (!Main.getPause()) {
            int k = e.getKeyCode();

            if (k == e.VK_LEFT) Player.setMovingLeft(true);
            if (k == e.VK_RIGHT) Player.setMovingRight(true);
            if (k == e.VK_UP) Player.setMovingUp(true);
            if (k == e.VK_DOWN) Player.setMovingDown(true);
            if (k == e.VK_P) {
                new PauseMenu();
            }
        }
    }


    public void keyReleased(KeyEvent e) {
        if (!Main.getPause()) {
            int k = e.getKeyCode();

            if (k == e.VK_LEFT) Player.setMovingLeft(false);
            if (k == e.VK_RIGHT) Player.setMovingRight(false);
            if (k == e.VK_UP) Player.setMovingUp(false);
            if (k == e.VK_DOWN) Player.setMovingDown(false);
        }
    }


    public void keyTyped(KeyEvent e) {}
}
