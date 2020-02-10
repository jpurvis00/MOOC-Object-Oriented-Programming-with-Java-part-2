import java.util.ArrayList;

public class Box implements ToBeStored{
    //Object attributes/vars
    private double maxWeight;
    private ArrayList<ToBeStored> box;

    //Object constructors
    public Box(double max){
        this.maxWeight = max;
        this.box = new ArrayList<ToBeStored>();
    }

    //Object methods
    //Adds an object to the Box class arrayList if the weight of the object does not increase the total
    //weight of all items in the box already above the box maxWeight.
    public void add(ToBeStored stored){
        if(stored.weight() + this.weight() < this.maxWeight)
            box.add(stored);
        else
            System.out.println("Total weight of box is too much.  Not added.");
    }

    //Calculates the weight of all objects in the arrayList using the ToBeStored interface
    public double weight(){
        double weight = 0;

        for(ToBeStored objWeight: this.box){
            weight += objWeight.weight();
        }

        return weight;
    }

    @Override //override the object class toString method
    public String toString(){
        return "Box: " + this.box.size() + " things, total weight " + this.weight() + " kg";
    }

    public void printAll(){
        for(Object obj: this.box){
            System.out.println(obj);
        }
    }
}
