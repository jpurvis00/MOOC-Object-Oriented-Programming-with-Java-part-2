package reader.criteria;

public class Both implements Criterion {
    //Object attributes/instance vars
    private Criterion criterion1;
    private Criterion criterion2;

    //Object constructors
    public Both(Criterion c1, Criterion c2){
        this.criterion1 = c1;
        this.criterion2 = c2;
    }

    //Object methods
    /*Only returns true of both paramaters that were passed in evaluate to true.
    * Ex.
    * Criterion criterion = new Both(
                new EndsWithQuestionOrExclamationMark(),
                new ContainsWord("beer")
      );*/
    @Override
    public boolean complies(String line){
        return this.criterion1.complies(line) && this.criterion2.complies(line);
    }

}
