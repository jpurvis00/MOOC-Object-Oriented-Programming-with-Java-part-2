import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Dictionary dictionary = new Dictionary();
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("porkkana"));

        System.out.println(dictionary.amountOfWords());

        ArrayList<String> translations = dictionary.translationList();
        for(String translation: translations) {
            System.out.println(translation);
        }
        */

        //Scanner reader = new Scanner(System.in);
        String input = "translate\n" + "monkey\n"  +
                "translate\n" + "cheese\n" +
                "add\n"  + "cheese\n" + "juusto\n" +
                "translate\n" + "cheese\n" +
                "quit\n";
        Scanner reader = new Scanner(input);
        Dictionary dict = new Dictionary();

        TextUserInterface ui = new TextUserInterface(reader, dict);
        ui.start();
    }
}
