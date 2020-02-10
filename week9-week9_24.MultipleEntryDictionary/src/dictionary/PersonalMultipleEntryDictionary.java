package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    //Object attributes/instance vars
    private Map<String, Set<String>> dictionary;

    //Object constructors
    public PersonalMultipleEntryDictionary(){
        this.dictionary = new HashMap<String, Set<String>>();
    }

    //Object methods
    /*Adds an untranslated word as a key to a hashMap if it doesn't exist and creates a new hashSet for
    that key to store a list of translated words.  If the key already exists, we add the new entry to the keys
    hashSet.
     */
    @Override
    public void add(String word, String entry){
        /*Check to see if the word has already been added to the hashMap.  If not, we
        must create a new entry with a new hashSet for all translated words.
         */
        if(!this.dictionary.containsKey(word))
            this.dictionary.put(word, new HashSet<String>());

        /*We must get the set containing all translated words.  Then add the new
        entry to that set.
         */
        this.dictionary.get(word).add(entry);
    }

    /*Returns the hashSet values for the passed in key*/
    @Override
    public Set<String> translate(String word){
        return this.dictionary.get(word);
    }

    /*Deletes the key from the hashMap*/
    @Override
    public void remove(String word){
        this.dictionary.remove(word);
    }
}
