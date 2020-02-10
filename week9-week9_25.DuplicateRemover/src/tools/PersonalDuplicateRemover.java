package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover{
    //Object attributes/instance vars
    private Set<String> word;
    private int duplicate;

    //Object constructors
    public PersonalDuplicateRemover(){
        this.word = new HashSet<String>();
        this.duplicate = 0;
    }

    //Object methods
    /*Adds a string to a hashSet.  We are using a hashSet in this particular case bc we don't
    want to store duplicate string.  If we were to use an arrayList, we would have to check it before
    adding.  If the string already exists and is not added, we increment the duplicate var to keep
    track of how many duplicates we had.
     */
    @Override
    public void add(String characterString) {
        if(!this.word.add(characterString))
            this.duplicate++;
    }

    /*Returns the # of duplicate strings that were to be added to the hashSet*/
    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.duplicate;
    }

    /*Returns all values in the hashSet*/
    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.word;
    }

    /*Resets the hashSet to empty and the duplicate var back to 0*/
    @Override
    public void empty() {
        this.duplicate = 0;
        this.word.clear();
    }
}
