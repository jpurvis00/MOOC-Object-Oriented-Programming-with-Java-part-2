import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Give a string: ");
        String input = reader.nextLine();

        printResults(isAWeekDay(input));
        printResults(allVowels(input));
        printResults(clockTime(input));
    }

    /*Checks a string to see if it's an abbreviation for a day of the week*/
    public static boolean isAWeekDay(String string){
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    /*Checks a string to see if all entered letters are vowels*/
    public static boolean allVowels(String string){
        return string.matches("[aeiouäö]*");
    }

    /*Checks a string to see if it conforms to military time*/
    public static boolean clockTime(String string){
        return string.matches("([01][0-9]|2[0-3])(:[0-5][0-9]){2}");
    }

    /*Prints the results of the string method tests*/
    public static void printResults(boolean result){
        if(result)
            System.out.println("The form is fine");
        else
            System.out.println("The form is wrong");
    }
}
