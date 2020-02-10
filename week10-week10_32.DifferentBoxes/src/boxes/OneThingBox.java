package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box {
    //Object attributes/instance vars
    private List<Thing> oneThingBox;

    //Object constructors
    public OneThingBox(){
        this.oneThingBox = new ArrayList<Thing>();
    }

    //Object methods
    /*Inherited from the Box abstract class*/
    /*Only one thing is allowed in this box regardless of weight.  If nothing is in the box, add it*/
    @Override
    public void add(Thing thing){
        if(this.oneThingBox.isEmpty())
            this.oneThingBox.add(thing);
    }

    /*Returns true if the thing object is already in the box, false if not*/
    @Override
    public boolean isInTheBox(Thing thing){
        if(this.oneThingBox.contains(thing))
            return true;

        return false;
    }
}
