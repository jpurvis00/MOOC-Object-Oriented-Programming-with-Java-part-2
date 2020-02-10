package movingfigure;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompoundFigure extends Figure {
    //Object attributes/instance vars
    private List<Figure> figureList;

    //Object constructors
    public CompoundFigure(){
        super(0, 0);
        this.figureList = new ArrayList<Figure>();
    }

    //Object methods
    /*Adds all figures to the ArrayList*/
    public void add(Figure figure){
        this.figureList.add(figure);
    }

    /*Calls the draw method of all figures.  Due to Polymorphism each draw method is called from the
    * correct class.  If the first figure in the arrayList is Circle, the circle draw method is called.*/
    @Override
    public void draw(Graphics graphics){
        for(Figure f : this.figureList){
            f.draw(graphics);
        }
    }

    /*Overrides the Figure class move method*/
    @Override
    public void move(int dx, int dy){
        for(Figure f : this.figureList){
            f.move(dx, dy);
        }
    }
}
