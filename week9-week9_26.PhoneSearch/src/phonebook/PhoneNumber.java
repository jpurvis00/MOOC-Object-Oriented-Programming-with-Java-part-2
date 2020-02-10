package phonebook;

import java.util.*;

public class PhoneNumber implements Comparable<PhoneNumber>{
    //Object attributes/instance vars
    private String name;
    private Set<String> phoneNumbers = new HashSet<String>();

    //Object constructors
    public PhoneNumber(String name){
        this.name = name;
    }

    public PhoneNumber(String name, String numb){
        this.name = name;
        this.phoneNumbers.add(numb);
    }

    //Object methods
    /*Returns the name as a string*/
    public String getName() {
        return this.name;
    }

    public void setPhoneNumbers(String numb){
        this.phoneNumbers.add(numb);
    }

    public Set<String> getPhoneNumbers(){
        return this.phoneNumbers;
    }

    @Override
    public String toString(){
        return this.name + " " + this.phoneNumbers;
    }

    /*By implementing the overriding equals and hashCode methods, we prevent the issue of adding
    two Person objects with the same name into the hashSet in the TextUserInteface class.  Two objects
    will always appear as different objects unless we have the two methods below.  In this case, the equals
    looks into the object and compares the names.  If they are the same, the duplicate will not be added
    to the hashSet.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber person = (PhoneNumber) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(PhoneNumber person){
        return this.name.compareToIgnoreCase((person.getName()));
    }
}
