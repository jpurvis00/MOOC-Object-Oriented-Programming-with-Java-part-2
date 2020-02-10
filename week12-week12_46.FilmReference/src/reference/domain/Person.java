package reference.domain;

import java.util.Objects;

public class Person {
    //Object attributes/instance vars
    private String name;

    //Object constructors
    public Person(String name){
        this.name = name;
    }

    //Object methods
    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
