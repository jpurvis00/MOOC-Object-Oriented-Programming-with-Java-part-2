package people;

public class Teacher extends Person{
    //Object attributes/instance vars
    private int salary;

    //Object constructors
    public Teacher(String name, String address, int salary){
        super(name, address); //Calls the constructor in the Person class
        this.salary = salary;
    }

    //Object methods
    /*Overrides the toString method in the superclass Person*/
    @Override
    public String toString(){
        /*super.toString() calls the toString method from the Person class*/
        return super.toString() + "\n  salary " + this.salary + " euros/month";
    }
}
