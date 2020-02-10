import java.util.*;

public class Points {
    //Object attributes/vars
    private ArrayList<Integer> length;
    private ArrayList<Integer> votes;
    private int totPoints;
    private Random  randNumb;

    //Object constructors
    public Points(){
        this.length = new ArrayList<Integer>();
        this.votes = new ArrayList<Integer>();
        this.totPoints = 0;
        this.randNumb = new Random();
    }

    //Object methods
    //Returns total points for athlete
    public int getTotPoints(){
        return this.totPoints;
    }

    public void setTotPoints(int points){
        this.totPoints += points;
    }

    /*Creates a random # from 60-120 and adds it to the length arrayList */
    public void setLength(){
        this.length.add(this.randNumb.nextInt(60) + 60);
    }

    /*Returns the last value in the length arrayList.  This is done so that we can get the current
    rounds length value since it's always added at the end of the arrayList.
     */
    public int getLength(){
        return this.length.get(this.length.size() - 1);
    }

    /*Returns all lengths in the length arrayList.  This is returned as a string in the following
    format: 9m, 8m, 10m
     */
    public String getAllLengths(){
        String allLengths = "";

        for(int length : this.length){
            allLengths += length;

            if(length != this.length.get(this.length.size() - 1)){
                allLengths += " m, ";
            } else {
                allLengths += " m";
            }
        }

        return allLengths;
    }

    /*Creates 5 judges scores in the votes arrayList.  We used an arrayList for this instead of an
    array so that we could used Collections.min/max on the List.  A simple array is not a list, an arrayList
    is.  We also clear the list each time this method is called so that it does not continue to keep track of
    all values.  We are only interested in 5 at a time.  A random # between 10-20 is added.
     */
    public void setVotes(){
        this.votes.clear();

        for(int i = 0; i < 5; i++){
            this.votes.add(this.randNumb.nextInt(10) + 10);
        }
    }

    /*Returns a string of all judges votes for the round in the following format:
    [11, 19, 13, 10, 15]
     */
    public String getVotes() {
        String allVotes = "[";

        for(int vote : this.votes){
            allVotes += vote;

            if(vote != this.votes.get(this.votes.size() - 1)){
                allVotes += ", ";
            } else {
                allVotes += "]";
            }
        }
        return allVotes;
    }

    /*Calculates the total points for the round.  This is figured by adding the round length to 3 of the
    judges scores.  We throw out the smallest and largest of the 5 scores.
     */
    public int calcRoundPoints(){
        int rPoints = 0;

        for(int point : this.votes){
            rPoints += point;
        }

        rPoints += getLength() - (Collections.min(this.votes) + Collections.max(this.votes));
        this.totPoints += rPoints;

        return rPoints;
    }

    @Override
    public String toString(){
        return "(" + this.totPoints + " points)";
    }
}