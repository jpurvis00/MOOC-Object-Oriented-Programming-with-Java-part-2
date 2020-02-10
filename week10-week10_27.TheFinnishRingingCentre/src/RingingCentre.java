import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {
    //Object attributes/instance vars
    private Map<Bird, List<String>> obsLocations;

    //Object constructors
    public RingingCentre(){
        this.obsLocations = new HashMap<Bird, List<String>>();
    }

    //Object methods
    public void observe(Bird bird, String place){
        /*If hashmap doesn't contain the bird object, add it and create a new arrayList*/
        if(!this.obsLocations.containsKey(bird))
            this.obsLocations.put(bird, new ArrayList<String>());

        /*Add the place to the hashMap*/
        this.obsLocations.get(bird).add(place);

    }

    public void observations(Bird bird){
        /*I kept getting a nullPointer error if I didn't check to see if the arrayList was null when
        using the size() method.  Separated those 2 situations out.
         */
        if(this.obsLocations.get(bird) != null) {
            System.out.println(bird + " observations: " + this.obsLocations.get(bird).size());

            /*Print out the arrayList one line at a time*/
            for(String loc : this.obsLocations.get(bird)){
                System.out.println(loc);
            }
        } else {
            System.out.println(bird + " observations: 0");

        }

    }
}
