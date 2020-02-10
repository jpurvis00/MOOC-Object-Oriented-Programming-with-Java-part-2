import java.util.HashMap;
import java.util.Map;

/*This class implements the Comparable interface so that we can sort the athletes using
the Collections.sort method.  We have overridden the comparTo method so that the Athlete objects
are sorted by total points.
 */
public class Athlete implements Comparable<Athlete> {
    //Object attributes/vars
    private String name;
    private Map<String, Points> athletePoints = new HashMap<String, Points>();

    //Object constructors
    public Athlete(String athlete, Points points){
        this.name = athlete;
        this.athletePoints.put(athlete, points);
    }

    //Object methods
    //Returns athlete name
    public String getName(){
        return this.name;
    }

    /*Returns the Points object from the athletePoints hashMap.  This is used so that we can access
    the Points class methods from another class.
     */
    public Points getPointsObject(String name){
        return this.athletePoints.get(name);
    }

    /*Overrides the compareTo method from the Comparable interface.  Will sort the athletes by total points from
    least to most.
     */
    @Override
    public int compareTo(Athlete athlete){
        return this.athletePoints.get(this.name).getTotPoints() - athlete.athletePoints.get(athlete.getName()).getTotPoints();
    }

    //Returns the object in a string format
    @Override
    public String toString(){
        return this.name;
    }
}