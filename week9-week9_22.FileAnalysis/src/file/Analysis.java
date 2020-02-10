package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Analysis {
    //Object attributes/instance vars
    private List<String> lines;

    //Object constructors
    public Analysis(File file){
        /*Creating an arrayList to store all the lines of the file separately.  This allows
        us to go through the file multiple times compared to using the Scanner object and
        hasNextLine() method which will only go through the file once.
         */
        this.lines = new ArrayList<String>();

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                this.lines.add(reader.nextLine());
            }

            reader.close();
        } catch(Exception e){
            //do nothing if an exception is thrown
        }
    }

    //Object methods
    /*Returns the # of lines in a file*/
    public int lines(){
        return this.lines.size();
    }

    /*Returns the # of chars in a file*/
    public int characters(){
        int numChars = 0;

        /*Go through each line and get the length.  Add it to our counter.*/
        for(String line : this.lines){
            numChars += line.length()+1;
        }

        return numChars;
    }
}
