package people;

public class Student extends Person {
    //Object attributes/instance vars
    private int credits;

    //Object constructors
    public Student(String name, String address){
        super(name, address); //Calls the constructor from the Person class
        this.credits = 0;
    }

    //Object methods
    public int credits(){
        return this.credits;
    }

    public void study(){
        this.credits++;
    }

    /*Overrides the toString method from the superclass Person*/
    @Override
    /*super.toString() calls the toString method from the Person class*/
    public String toString(){
        return super.toString() + "\n  credits " + this.credits;
    }
}
