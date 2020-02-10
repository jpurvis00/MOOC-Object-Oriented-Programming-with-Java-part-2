import java.util.Scanner;

public class Reader {
    //Object attributes/vars
    private Scanner reader;


    //Object constructors
    public Reader(){
        this.reader = new Scanner(System.in);
    }

    //Object methods
    //Reads a string of user input
    public String readString(){
        return reader.nextLine();
    }

    //Reads an int from user input
    public int readInteger(){
        return Integer.parseInt(reader.nextLine());
    }
}
