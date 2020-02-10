import java.io.File;
import java.util.Scanner;

public class Printer {
    //Object attributes/instance vars
    private File fName;

    //Object constructors
    /*Constructor initializes the Scanner object with a filename.  *Constructor throws the exceptions
    if the filename does not exist according to the assignment specs.

    *I could not get this to work w the tests.  I had to move the Scanner into the printLinesWhichContain
     method and have that method throw the exeption.  Creating the scanner in the constructor would only
     let us read through the file once.  If we made a subsequent call to the method it would do nothing
     bc we were at the end of the file.

     ex.
        Printer t = new Printer("src/textfile22.txt");
        t.printLinesWhichContain("word");
        t.printLinesWhichContain("koe");
    */
    public Printer(String fileName){
        this.fName = new File(fileName);
    }

    //Object methods
    /*Reads through the file line by line.  If the word parameter is empty, print all contents of the
    file.  If it's not empty, print each line that contains that word.  Is case sensitive.
     */
    public void printLinesWhichContain(String word) throws Exception{
        Scanner reader = new Scanner(this.fName);

        while(reader.hasNextLine()){
            String line = reader.nextLine();
            if(word.isEmpty() || line.contains(word)) {
                System.out.println(line);
            }
        }

        reader.close();
    }
}
