
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        /*Store the contents of each line in the arrayList*/
        List<String> lines = new ArrayList<String>();

        /*Create a scanner for the file*/
        Scanner reader = new Scanner(new File(file));

        /*Read each line and add it to the ArrayList*/
        while(reader.hasNextLine()){
            lines.add(reader.nextLine());
        }

        reader.close();

        return lines;
    }

    public void save(String file, String text) throws IOException {
        /*Create a writer obj for the file*/
        FileWriter writer = new FileWriter(file);

        writer.write(text);

        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        /*Create a writer obj for the file*/
        FileWriter writer = new FileWriter(file);

        for(String line : texts){
            writer.write(line + "\n");
        }

        writer.close();
    }
}
