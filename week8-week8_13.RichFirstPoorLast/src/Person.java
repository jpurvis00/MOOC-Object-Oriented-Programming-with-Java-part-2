public class Person implements Comparable<Person> {

    private int salary;
    private String name;

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return name + " " + salary;
    }

    //This lets us make the call: Collections.sort(people) in Main to sort people by salary.
    //Reverse the order to get lowest to highest.
    @Override
    public int compareTo(Person person) {
        return person.getSalary() - this.salary;
    }
}
