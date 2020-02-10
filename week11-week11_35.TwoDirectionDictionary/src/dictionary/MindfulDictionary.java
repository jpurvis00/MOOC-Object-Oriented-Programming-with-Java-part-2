package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/********************************************
 * Class solution has the translations being put in twice.
 * ex. apina -> monkey
 *      apina:monkey
 *      monkey:apina
 *
 * I only put them in one way.  I still searched both the keys and values for the
 * specified translated word.
 */
public class MindfulDictionary {
    //Object attributes/instance vars
    private Map<String, String> dictionary;
    private File fName;

    //Object constructors
    public MindfulDictionary(){
        this.dictionary = new HashMap<String, String>();
    }

    public MindfulDictionary(String file){
        this();
        this.fName = new File(file);
    }

    //Object methods
    /*Adds a word and it's translation to a hashMap.  Only add it if the key word does not already exist*/
    public void add(String word, String translation){
        if(!this.dictionary.containsKey(word))
            this.dictionary.put(word, translation);
    }

    /*Translate a give word from english -> finnish or vice versa.  If the word is not in the hashMap,
    return null;
     */
    public String translate(String word){
        /*word is a key, return the value*/
        if(this.dictionary.containsKey(word))
            return this.dictionary.get(word);

        /*word was not a key, it is a value, return the key*/
        for(String key : this.dictionary.keySet()){
            if(this.dictionary.get(key).equals(word)) {
                return key;
            }
        }

        /*word was not found, return null*/
        return null;
    }

    /*Removes a word from the hashMap.  The word can be a key or a value and the entry will be removed*/
    public void remove(String word){
        /*Word is a key.  Remove the entry*/
        if(this.dictionary.containsKey(word))
            this.dictionary.remove(word);

        /*Word is a value.  Iterate through the keys until you find the word.  Remove that entry*/
        if(this.dictionary.containsValue(word)){
            for(String key : this.dictionary.keySet()){
                if(this.dictionary.get(key).equals(word))
                    word = key;
            }

            this.dictionary.remove(word);
        }
    }

    /*Loads the dictionary hashMap with all values from the specified file.  Return true if successful,
    false if not.
     */
    public boolean load(){
        try {
            Scanner reader = new Scanner(this.fName);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                /*File has words in following format  test:test1.  Split the words at : and store in an array*/
                String[] parts = line.split(":");

                add(parts[0], parts[1]);
            }

            reader.close();

            return true;
        } catch (IOException e) {
            return true;
        }
    }

    /*Writes the dictionary hashMap to a file.  This saves any changes/additions made to the hashMap to
    the final file.
     */
    public boolean save(){
        try{
            FileWriter writer = new FileWriter(this.fName);

            /*Write key and value to file in the following format -  key:value*/
            for(String key : this.dictionary.keySet()){
                writer.write(key + ":" + this.dictionary.get(key) + "\n");
            }

            writer.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void displayAll(){
        System.out.println(this.dictionary);
    }
}
