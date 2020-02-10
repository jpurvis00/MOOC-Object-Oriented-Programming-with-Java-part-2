package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    //Object attributes/instance vars
    private File file;
    private List<String> lines;

    //Object constructors
    public WordInspection(java.io.File file){
        this.file = file;
        this.lines = new ArrayList<String>();
        readFile();
    }

    //Object methods
    /*Reads a file and puts each line as a String into an arrayList*/
    public void readFile() {
        try{
            Scanner reader = new Scanner(this.file, "UTF-8");

            while(reader.hasNextLine()){
                this.lines.add(reader.nextLine());
            }

            reader.close();
        } catch(Exception e){
            System.out.println("File does not exist!");
        }
    }

    /*Returns the # of words in a file.  For this assignment we can assume there is 1 word per line*/
    public int wordCount(){
        return this.lines.size();
    }

    /*Returns all words in the file that contain the char Z in an arrayList*/
    public List<String> wordsContainingZ(){
        List<String> wordsWZ = new ArrayList<String>();

        /*Go through each line in the file and check to see if the word contains the char z.
        If so, add to the arrayList and return it.
         */
        for(String line : this.lines){
            if(line.contains("z"))
                wordsWZ.add(line);
        }

        return wordsWZ;
    }

    /*

     */
    public List<String> wordsEndingInL(){
        List<String> wordsEndingWL = new ArrayList<String>();

        for(String line : this.lines){
            if(line.endsWith("l"))
                wordsEndingWL.add(line);
        }

        return wordsEndingWL;
    }

    /*Checks each word to see if its a palindrome and returns all in an arrayList.
    *
    * Turns out this is really easy using a built in string method
    * for (String word : this.words) {
    *   if (word.equals(reverse(word))) {
    *       toBeReturned.add(word);
    *   }
    * }
    */
    public List<String> palindromes(){
        List<String> palindromes = new ArrayList<String>();

        //Check each word
        for(String line : this.lines){
            //keeps track if word is a palindrome or not
            boolean isPalin = true;

            //we only have to do half the length of the word comparisons
            for(int i = 0; i < line.length() / 2; i++){
                //compare first to last char in word and move inwards.  If any of the comparisons
                //for that word are !=, it is not a palindrome
                if(line.charAt(i) != line.charAt(line.length() - i - 1))
                    isPalin = false;
            }

            if(isPalin)
                palindromes.add(line);
        }

        return palindromes;
    }

    /*Checks to see if a word contains all the finnish vowels.  IF so, we add it to an arrayList
    and return the entire list.
     */
    public List<String> wordsWhichContainAllVowels(){
        List<String> allVowels = new ArrayList<String>();
        String vowels = "aeiouyäö";

        /*This is my original solution.  I could not figure out how to get contains to recognize a char in the
        form of char[] = {'a','e','i','o','u','y','ä','ö'}

        I think this is bc contains is looking for an CharacterSequence, not a char.  By using the proc below,
        "" + char, it appears we are now passing it a sequence instead of just a char.  Class solution splits my
        code below into a helper method.  The second for loop is done in a boolean method.
         */
        /*for(String line : this.lines) {
            if(line.contains("a") && line.contains("e") && line.contains("i") && line.contains("o") && line.contains("u") && line.contains("y") && line.contains("ä") && line.contains("ö"))
                allVowels.add(line);
        }*/

        for(String line : this.lines) {
            boolean allVowelsCon = true;
            for(char vowel : vowels.toCharArray()) {
                if(!line.contains("" + vowel))
                    allVowelsCon = false;
            }

            if(allVowelsCon)
                allVowels.add(line);
        }

        return allVowels;
    }
}
