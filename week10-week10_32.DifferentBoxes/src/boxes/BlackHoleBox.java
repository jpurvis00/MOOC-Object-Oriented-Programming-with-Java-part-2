package boxes;

import java.util.HashSet;
import java.util.Set;

public class BlackHoleBox extends Box {
    //Object attributes/instance vars
    private Set<Thing> blackHoleBox;

    //Object constructors
    public BlackHoleBox(){
        this.blackHoleBox = new HashSet<Thing>();
    }

    //Object methods
    /*Inherited from the Box abstract class*/
    /*Add any thing object to the hashSet.  We don't care about weigth*/
    @Override
    public void add(Thing thing){
        this.blackHoleBox.add(thing);
    }

    /*Always return false.  Nothing can be found in the black hole*/
    @Override
    public boolean isInTheBox(Thing thing){
        return false;
    }
}
