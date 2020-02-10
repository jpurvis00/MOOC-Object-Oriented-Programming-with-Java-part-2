package personnel;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Employees university = new Employees();
        university.add(new Person("Matti", Education.D));
        university.add(new Person("Pekka", Education.GRAD));
        university.add(new Person("Arto", Education.D));

        university.print();

        university.fire(Education.GRAD);

        System.out.println("==");

        university.print();

        System.out.println("==");

        Employees t = new Employees();
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("Arto", Education.D));
        list.add(new Person("Pekka", Education.GRAD));
        t.add(list);
        t.print();

        System.out.println("==");

        Employees s = new Employees();
        Person h = new Person("Arto", Education.D);
        s.add(h);
        s.print(Education.D);
    }
}
