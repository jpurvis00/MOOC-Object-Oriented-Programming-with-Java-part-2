/*
I tried to do a better job at splictting the code up so that most methods only accomplished one thing
making the code easier to read/understand.

Class prints a given word surrounded by a frame of smiley faces.  If the word has an odd amount of
chars, add an extra space after the word.
 */
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }

    //Finds out how long the width of the frame needs to be given an even/odd
    //amount of chars.
    private static void printWithSmileys(String characterString){
        int length = characterString.length() + 6;

        if(isLengthOdd(characterString))
            length += 1;

        printOutput(characterString, length);
    }

    //Print finished output
    private static void printOutput(String characterString, int length){
        printRowSmileys(length);
        printRowTextAndSmileys(characterString);
        printRowSmileys(length);
    }

    //Prints the middle line of text in the frame which includes the give word.
    private static void printRowTextAndSmileys(String charString){
        if(isLengthOdd(charString))
            System.out.print(":) " + charString + "  :)");
        else
            System.out.print(":) " + charString + " :)");

        System.out.println();
    }

    //Returns boolean if the word has an odd/even # of chars
    private static boolean isLengthOdd(String charString){
        return charString.length() % 2 == 1;
    }

    //Prints the top/bottom rows of the frame
    private static void printRowSmileys(int length){
        for(int i = 0; i < length / 2; i++) {
            System.out.print(":)");
        }

        System.out.println();
    }
}
