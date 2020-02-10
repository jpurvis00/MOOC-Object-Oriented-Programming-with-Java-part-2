package boxes;

import java.util.HashSet;
import java.util.Set;

/*We are inheriting the Box abstract class.  Because the class is abstract, that means that we
don't have to completely define methods.  We can override those inherited methods and create our own
methods here.
 */
public class MaxWeightBox extends Box {
    //Object attributes/instance vars
    private int maxWeight;
    private Set<Thing> thingsInBox;

    //Object constructors
    public MaxWeightBox(int maxWeight){
        this.maxWeight = maxWeight;
        this.thingsInBox = new HashSet<Thing>();
    }

    //Object methods
    /*Inherited from the Box abstract class*/
    /*Adds a thing object to our MaxWeightBox hashSet as long as the total weight of the
    new thing plus whatever is already in the box doesn't go over the maxWeight.
     */
    @Override
    public void add(Thing thing){
        int totWeight = 0;

        /*Get the boxes total weight before adding the new thing*/
        for(Thing item : this.thingsInBox){
            totWeight += item.getWeight();
        }

        /*If total weight is <= max weight, add to hashSet*/
        if(totWeight + thing.getWeight() <= this.maxWeight)
            this.thingsInBox.add(thing);
    }

    /*Returns true if the box contains the thing object, false if not*/
    @Override
    public boolean isInTheBox(Thing thing){
        return this.thingsInBox.contains(thing);
    }
}
