package people;

public class Person {
    //Object attributes/instance vars
    private String name;
    private String address;

    //Object constructors
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    //Object methods
    @Override
    public String toString(){
        return this.name + "\n  " + this.address;
    }
}
