package tools;

public class Main {
    public static void main(String[] args) {
        /*DuplicateRemover wordList = new PersonalDuplicateRemover();
        wordList.add("first");
        wordList.add("second");
        wordList.add("first");
        wordList.add("first");

        System.out.println("list: " + wordList.getUniqueCharacterStrings());
        System.out.println("dupes: " + wordList.getNumberOfDetectedDuplicates());

        System.out.println("empty list and count");
        wordList.empty();

        System.out.println("list: " + wordList.getUniqueCharacterStrings());
        System.out.println("dupes: " + wordList.getNumberOfDetectedDuplicates());*/

        DuplicateRemover remover = new PersonalDuplicateRemover();
        remover.add("first");
        remover.add("second");
        remover.add("first");

        System.out.println("Current number of duplicates: " +
                remover.getNumberOfDetectedDuplicates());

        remover.add("last");
        remover.add("last");
        remover.add("new");

        System.out.println("Current number of duplicates: " +
                remover.getNumberOfDetectedDuplicates());

        System.out.println("Unique characterStrings: " +
                remover.getUniqueCharacterStrings());

        remover.empty();

        System.out.println("Current number of duplicates: " +
                remover.getNumberOfDetectedDuplicates());

        System.out.println("Unique characterStrings: " +
                remover.getUniqueCharacterStrings());
    }
}
