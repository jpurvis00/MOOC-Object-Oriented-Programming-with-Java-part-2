package movingfigure;

import java.awt.*;

public abstract class Figure {
    //Object attributes/instance variables
    private int x;
    private int y;

    //Object constructors
    public Figure(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Object methods
    /*Used to move a figure by dx and dy*/
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    /*Returns X coordinate*/
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    /*Abstract method used to draw different types of figures: boxes, squares, circles, etc*/
    public abstract void draw(Graphics graphics);
}
