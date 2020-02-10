import java.util.ArrayList;

public class Container {
    //Object attributes/vars
    private int maxWeight;
    private ArrayList<Suitcase> container;

    //Object constructors
    public Container(int maxWeight){
        this.maxWeight = maxWeight;
        this.container = new ArrayList<Suitcase>();
    }

    //Object methods
    public void addSuitcase(Suitcase suitcase){
        if(totalContWeight() + suitcase.totalWeight() <= maxWeight)
            this.container.add(suitcase);
    }

    public int totalContWeight(){
        int totalContWeight = 0;

        for(Suitcase suitcases : this.container){
            totalContWeight += suitcases.totalWeight();
        }

        return totalContWeight;
    }

    public void printThings(){
        for(Suitcase suitcases : this.container){
            suitcases.printThings();
        }
    }

    public String toString(){
        return this.container.size() + " suitcases (" + totalContWeight() + " kg)";
    }
}
