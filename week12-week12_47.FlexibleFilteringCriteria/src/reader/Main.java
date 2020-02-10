package reader;

import reader.criteria.*;

public class Main {

    public static void main(String[] args) {
        //String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
        /*String address = "https://www.gutenberg.org/files/2554/2554-0.txt";
        GutenbergReader book = new GutenbergReader(address);

        Criterion criterion = new ContainsWord("beer");

        for (String line : book.linesWhichComplyWith(criterion)) {
            System.out.println(line);
        }*/

        String address = "https://www.gutenberg.org/files/2554/2554-0.txt";
        GutenbergReader book = new GutenbergReader(address);

        //Criterion criterion = new AllLines();
        //Criterion criterion = new EndsWithQuestionOrExclamationMark();
        //Criterion criterion = new LengthAtLeast(40);
        /*Criterion criterion = new Both(
                new EndsWithQuestionOrExclamationMark(),
                new ContainsWord("beer")
        );*/
        //Criterion criterion = new Not( new LengthAtLeast(10) );
        Criterion criterion =new AtLeastOne(
                new ContainsWord("beer"),
                new ContainsWord("milk"),
                new ContainsWord("oil")
        );

        for (String line : book.linesWhichComplyWith(criterion)) {
            System.out.println(line);
        }
    }
}
