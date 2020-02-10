package movingfigure;

import java.awt.*;

public class Box extends Figure {
    //Object attributes/instance vars
    private int width;
    private int height;

    //Object constructors
    public Box(int x, int y, int width, int height){
        super(x, y); //Calls the Figure constructor
        this.width = width;
        this.height = height;
    }

    //Object methods
    /*Draws a box*/
    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(super.getX(), super.getY(), this.width, this.height);
    }
}
