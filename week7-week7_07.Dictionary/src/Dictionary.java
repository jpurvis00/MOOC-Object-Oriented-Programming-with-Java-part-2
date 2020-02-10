import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    //Object attributes/vars
    private HashMap<String, String> dictionary;

    //Object constructors
    public Dictionary(){
        this.dictionary = new HashMap<String, String>();
    }

    //Object methods
    //Returns the translated word or null if the word does not exist.
    public String translate(String word){
        if(this.dictionary.containsKey(word))
            return this.dictionary.get(word);

        return null;
    }

    //Adds the word and tranlated word to the hashmap.
    public void add(String word, String translation){
        this.dictionary.put(word, translation);
    }

    //Returns how many translations are in the dictionary object.
    public int amountOfWords(){
        return this.dictionary.size();
    }

    //Returns an ArrayList of all entries in the dictionary object.  Both their
    //word and translated word.  ex. banaani = banana
    public ArrayList<String> translationList(){
        //Create a new arrayList
        ArrayList<String> allTranslations = new ArrayList<String>();

        //Go through each entry in the hashmap and assign the key value to the word var
        for(String word : this.dictionary.keySet()){
            //Retrieve the value associated with the word from the hashmap and add it to the arrayList
            allTranslations.add(word + " = " + this.dictionary.get(word));
        }

        return allTranslations;
    }
}
