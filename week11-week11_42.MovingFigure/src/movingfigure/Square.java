package movingfigure;

import java.awt.*;

public class Square extends Figure {
    //Object attributes/instance vars
    private int sideLength;

    //Object constructors
    public Square(int x, int y, int sideLength){
        super(x, y);  //Calls the Figure constructor
        this.sideLength = sideLength;
    }

    //Object methods
    /*Draws a rectangle*/
    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(super.getX(), super.getY(), this.sideLength, this.sideLength);
    }
}
