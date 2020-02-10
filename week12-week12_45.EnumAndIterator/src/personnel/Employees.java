package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    //Object attributes/instance vars
    private List<Person> employees;

    //Object constructors
    public Employees(){
        this.employees = new ArrayList<Person>();
    }

    //Object methods
    /*Adds a Person object to a List*/
    public void add(Person person){
        this.employees.add(person);
    }

    /*Takes a list of Person objects and adds each one to our List*/
    public void add(List<Person> persons){
        for(Person person : persons) {
            this.employees.add(person);
        }
    }

    /*Prints each Person object*/
    public void print(){
        for(Person person : this.employees){
            System.out.println(person);
        }
    }

    /*Prints all Person object that match the education parameter that is passed in*/
    public void print(Education education){
        /*Create an iterator for the employees list*/
        Iterator<Person> iterator = this.employees.iterator();

        /*Go through each element in the list*/
        while(iterator.hasNext()){
            /*Assign the next element to a Person object*/
            Person person = iterator.next();

            /*Only print out the matching Person objects*/
            if(person.getEducation().equals(education)) {
                System.out.println(person);
            }
        }
    }

    /*Removes a Person object from the employees list.  Must be done with an iterator so that
    * we don't receive a ConcurrentModificationException error*/
    public void fire(Education education){
        Iterator<Person> iterator = this.employees.iterator();

        while(iterator.hasNext()){
            if(iterator.next().getEducation().equals(education))
                iterator.remove();
        }
    }
}
