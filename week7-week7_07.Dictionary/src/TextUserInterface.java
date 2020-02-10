import java.util.Scanner;

public class TextUserInterface {
    //Object attributes/vars
    private Scanner input;
    private Dictionary dict;

    //Object constructors
    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.input = reader;
        this.dict = dictionary;
    }

    //Object methods
    //Starts our user interface
    public void start(){
        System.out.println("Statement:\n  add - adds a word pair to the dictionary\n" +
                "  translate - asks a word and prints its translation\n" +
                "  quit - quit the text user interface");

        while(true){
            System.out.println();
            System.out.print("Statement: ");
            String userInput = this.input.nextLine();

            if(userInput.equals("quit")){
                System.out.println("Cheers!");
                break;
            } else if(userInput.equals("add")) {
                System.out.print("In Finnish: ");
                String fWord = this.input.nextLine();
                System.out.print("Translation: ");
                String eWord = this.input.nextLine();
                add(fWord, eWord);
            } else if(userInput.equals("translate")) {
                System.out.print("Give a word: ");
                String fWord = this.input.nextLine();
                System.out.print("Translation: " + translate(fWord));
                System.out.println();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }

    //Adds a finnnish and english word to the dictionary object hashmap
    private void add(String finnishWord, String englishWord){
        this.dict.add(finnishWord, englishWord);
    }

    //Returns the english version of the inputted finish word.
    private String translate(String finnishWord){
        if(this.dict.translate(finnishWord) != null)
            return this.dict.translate(finnishWord);

        return "Word not found!";
    }
}
