package reader.criteria;

public class LengthAtLeast implements Criterion {
    //Object attributes/instance vars
    private int count;

    //Ojbect constructors
    public LengthAtLeast(int count){
        this.count = count;
    }

    //Object methods
    /*Returns true if line length is >= specified length.*/
    @Override
    public boolean complies(String line){
        if(line.length() >= count)
            return true;

        return false;
    }
}
