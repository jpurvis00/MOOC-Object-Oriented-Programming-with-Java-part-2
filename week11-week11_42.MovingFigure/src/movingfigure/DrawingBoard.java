package movingfigure;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {
    //Object attributes/instance vars
    private Figure figure;

    //Object constructors
    public DrawingBoard(Figure figure){
        super.setBackground(Color.WHITE);
        this.figure = figure;
    }

    //Object methods
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        figure.draw(graphics);
    }
}
