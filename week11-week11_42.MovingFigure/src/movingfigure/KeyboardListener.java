package movingfigure;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    //Object attributes/instance vars
    private Component component;
    private Figure figure;

    //Object constructors
    public KeyboardListener(Component component, Figure figure){
        this.component = component;
        this.figure = figure;
    }

    //Object methods
    /*Listens for the arrow keys being pressed and moves the object by 1 the appropriate way*/
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.figure.move(-1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.figure.move(1, 0);
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            this.figure.move(0, -1);
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            this.figure.move(0, 1);
        }

        /*Repaints the canvas after every keystroke*/
        this.component.repaint();
    }

    /*Following must be included since they are inherited from KeyListener.  We do not need
    * to implement anything in the body though.*/
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
