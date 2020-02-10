public class Thing {
    //Object attributes/vars
    private String name;
    private int weight;

    //Object constructors
    public Thing(String name, int weigth){
        this.name = name;
        this.weight = weigth;
    }

    //Object methods
    //Returns the name of the thing
    public String getName(){
        return this.name;
    }

    //Returns the weight of the thing
    public int getWeight(){
        return this.weight;
    }

    //Prints a string representation of the Thing object
    public String toString(){
        return this.name + " (" + this.weight + " kg)";
    }
}
