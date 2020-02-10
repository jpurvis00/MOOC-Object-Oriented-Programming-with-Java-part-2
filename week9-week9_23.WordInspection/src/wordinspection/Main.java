package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt

        WordInspection wi = new WordInspection(file);
        System.out.println("Number of words: " + wi.wordCount());
        System.out.println("Words that contain Z: " + wi.wordsContainingZ());
        System.out.println("Words that contain l: " + wi.wordsEndingInL());
        System.out.println("Palindromes: " + wi.palindromes());
        System.out.println("All vowels: " + wi.wordsWhichContainAllVowels());
    }
}
