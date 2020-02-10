import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();

        for (String line : t.read("src/testinput1.txt")) {
            System.out.println(line);
        }

        t.save("src/testinput1.txt", "hello world!");

        List<String> lines = new ArrayList<String>();
        lines.add("people of earth");
        lines.add("how are you?");
        lines.add("yoko");

        t.save("src/testinput1.txt", lines);
    }
}
