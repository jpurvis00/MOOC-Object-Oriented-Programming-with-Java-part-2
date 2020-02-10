import validation.Person;
import validation.Calculator;

public class Main {
    public static void main(String[] args) {
        Person jeff = new Person("jeff", 119);
        System.out.println("Name: " + jeff.getName() + " age: " + jeff.getAge());

        Calculator calc = new Calculator();
        System.out.println(calc.multiplication(4));

        System.out.println(calc.binomialCoefficient(7, 2));
    }
}
