package reader.criteria;

public class AllLines implements Criterion {
    /*Returns true for all lines*/
    @Override
    public boolean complies(String line){
        return true;
    }
}
