public class Main {
    public static void main(String[] args) {
        /*Book book1 = new Book("Fedor Dostojevski", "Crime and Punishment", 2.0);
        Book book2 = new Book("Robert Martin", "Clean Code", 1.0);
        Book book3 = new Book("Kent Beck", "Test Driven Development", 0.5);

        CD cd1 = new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD cd2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD cd3 = new CD("Rendezvous Park", "Closer to Being Here", 2012);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);*/

        /*Box box = new Box(10.0);

        box.add( new Book("Fedor Dostojevski", "Crime and Punishment", 10.0) ) ;
        box.add( new Book("Robert Martin", "Clean Code", 1.0) );
        box.add( new Book("Kent Beck", "Test Driven Development", 0.7) );

        box.add( new CD("Pink Floyd", "Dark Side of the Moon", 1973) );
        box.add( new CD("Wigwam", "Nuclear Nightclub", 1975) );
        box.add( new CD("Rendezvous Park", "Closer to Being Here", 2012) );

        System.out.println( box );
        box.printAll();*/

        Box laatikko = new Box(10);
        laatikko.add( new Book("Horstman", "Core Java",5) );
        laatikko.add( new Book("Beck", "Test Driven Development",2) );
        laatikko.add( new Book("Nietzsche", "Also spracht Zarahustra",4) );
        System.out.println(laatikko.toString());

        Box box2 = new Box(100);
        box2.add(new Book("Purvis", "Being a Purvis", 3));
        box2.add(new Book("Purvis2", "Being a Purvis", 3));
        box2.add(new Book("Purvis3", "Being a Purvis", 3));
        System.out.println(box2);

        Box box3 = new Box(20);
        box3.add(laatikko);
        box3.add(box2);
        System.out.println(box3);

        box3.add(box3);
    }
}
