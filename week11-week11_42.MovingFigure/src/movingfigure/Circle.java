package movingfigure;

import java.awt.*;

public class Circle extends Figure {
    //Object attributes/instance variables
    private int diameter;

    //Object constructors
    public Circle(int x, int y, int diameter){
        super(x, y); //Calls the Figure constructor
        this.diameter = diameter;
    }

    //Object methods
    /*Draws a circle*/
    @Override
    public void draw(Graphics graphics){
        graphics.fillOval(super.getX(), super.getY(), diameter, diameter);
    }
}
