import java.util.ArrayList;

public class Suitcase {
    //Object attributes/vars
    private int maxWeight;
    private ArrayList<Thing> thing;

    //Object constructors
    public Suitcase(int weight){
        this.maxWeight = weight;
        this.thing = new ArrayList<Thing>();
    }

    //Object methods
    //Adds a thing object to an ArrayList as long as the weight does not push the total weight
    //over the maxWeight.
    public void addThing(Thing thing){
        if(totalWeight() + thing.getWeight() <= this.maxWeight)
            this.thing.add(thing);
    }

    //Changes the tense on the word thing for the toString method.
    private String setProperEnglish(){
        if(this.thing.size() == 0)
            return "empty ";
        else if(this.thing.size() == 1)
            return "thing ";
        else
            return "things";
    }

    //Returns the total weight of all things in the suitcase
    public int totalWeight(){
        int totalWeight = 0;

        for(Thing things : this.thing){
            totalWeight += things.getWeight();
        }

        return totalWeight;
    }

    //Prints all things contained in the arrayList
    public void printThings(){
        for(Thing things : this.thing){
            System.out.println(things.toString());
        }
    }

    //Returns an object so that we can access all elements of the object.  Goes through all
    //objects in the ArrayList and finds the one that has the heaviest weight and returns it.
    //Returns null if the ArrayList has no objects in it.
    public Thing heaviestThing(){
        Thing heaviest = null;

        if(this.thing.size() == 0)
            return heaviest;
        else
            heaviest = this.thing.get(0);  //Assign the first object in the ArrayList to the heaviest object.

        //Goes through the whole ArrayList and compares weights storing the object with the greatest weight
        //in the heaviest object
        for(Thing things : this.thing){
            if(things.getWeight() > heaviest.getWeight())
                heaviest = things;
        }

        return heaviest;
    }

    //Prints out string representation of the object
    public String toString(){
        return this.thing.size() + " " + setProperEnglish() + " (" + totalWeight() + " kg)";
    }
}
