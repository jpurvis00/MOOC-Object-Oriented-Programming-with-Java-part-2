package reference.comparator;

import reference.domain.Person;

import java.util.Comparator;
import java.util.Map;

public class PersonComparator implements Comparator<Person> {
    //Object attributes/instance vars
    private Map<Person, Integer> peopleIdent;

    //Object constructors
    public PersonComparator(Map<Person, Integer> peopleIdentities){
        this.peopleIdent = peopleIdentities;
    }

    //Object methods
    @Override
    public int compare(Person p1, Person p2){
        return this.peopleIdent.get(p2) - this.peopleIdent.get(p1);
    }
}
