import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        TextUserInterface ui = new TextUserInterface(reader);
        ui.start();
    }
}
