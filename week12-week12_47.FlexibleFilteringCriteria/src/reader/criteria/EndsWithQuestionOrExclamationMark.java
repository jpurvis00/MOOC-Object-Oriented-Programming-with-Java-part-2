package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion {
    /*Returns true if a line ends w a ? or !.*/
    @Override
    public boolean complies(String line){
        if(line.endsWith("?") || line.endsWith("!"))
            return true;

        return false;
    }
}
