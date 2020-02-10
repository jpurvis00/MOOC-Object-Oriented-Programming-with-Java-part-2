package reader.criteria;

public class Not implements Criterion {
    //Object attributes/instance vars
    private Criterion not;

    //Object constructors
    public Not(Criterion c1){
        this.not = c1;
    }

    //Object methods
    /*Returns the opposite of the criteria.  If LengthAtLeast(10) is passed in, we return all
    * lines who's size is < 10*/
    @Override
    public boolean complies(String line){
        return !this.not.complies(line);
    }
}
