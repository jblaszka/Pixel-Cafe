package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.TreeSet;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed;
    public boolean accepted;
    public boolean relased;
    Background backgroundView = new Background(this);

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_S -> downPressed = true;
            case KeyEvent.VK_W -> upPressed = true;
            case KeyEvent.VK_ENTER -> accepted = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        relased = true;
        switch (code) {
            case KeyEvent.VK_W -> upPressed = false;
            case KeyEvent.VK_S -> downPressed = false;
            case KeyEvent.VK_ENTER -> accepted = false;
        }
    }
}
