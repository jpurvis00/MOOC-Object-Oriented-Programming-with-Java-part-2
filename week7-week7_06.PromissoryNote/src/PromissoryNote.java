import java.util.HashMap;

public class PromissoryNote {
    //Object atributes/vars
    private HashMap<String, Double> debtNotes;

    //Object constructors
    public PromissoryNote(){
        this.debtNotes = new HashMap<String, Double>();
    }


    //Object methods
    //Creates a new entry in the hashmap
    public void setLoan(String toWhom, double value){
        this.debtNotes.put(toWhom, value);
    }

    //Retrieves an entry from the hashmap.  If the key does not exist, return 0.
    public double howMuchIsTheDebt(String whose){
        if(this.debtNotes.containsKey(whose))
            return this.debtNotes.get(whose);

        return 0;
    }
}
