package reader.criteria;

public class AtLeastOne implements Criterion {
    //Object attributes/instance vars
    private Criterion[] c1;

    //Object constructors
    /*Creating this constructor to be able to receive as many parameters as get passed. The
    * following are allowed:
    * AtLeastOne(new ContainsWord("beer"))
    * AtLeastOne(new ContainsWord("beer"), new ContainsWord("milk"))
    * AtLeastOne(new ContainsWord("beer"), new ContainsWord("milk"), new ContainsWord("oil"))*/
    public AtLeastOne(Criterion... c1){
        this.c1 = c1;
    }

    //Object methods
    /*Cycle through each parameter that was passed in to the constructor.  These are stored in the array
    of c1, thus the for loop using c1.length.  If it complies, return true else return false.*/
    @Override
    public boolean complies(String line){
        boolean state = false;

        for(Criterion criterion : this.c1){
            if(criterion.complies(line))
                state = true;
        }

        return state;
    }
}
