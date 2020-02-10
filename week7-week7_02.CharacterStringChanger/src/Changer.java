import java.util.ArrayList;

public class Changer {
    //Object attributes/vars
    private ArrayList<Change> listOfChanges;

    //Object constructors
    public Changer(){
        this.listOfChanges = new ArrayList<Change>();
    }

    //Object methods
    //Add Change objects to the ArrayList
    public void addChange(Change change){
        listOfChanges.add(change);
    }

    //Goes through each object in the ArrayList and performs each one separately to the
    //passed in characterString which replaces a char w a char.  The new word is then returned.
    public String change(String characterString){
        String newWord = characterString;

        for(Change changes : this.listOfChanges){
            newWord = changes.change(newWord);
        }

        return newWord;
    }
}
