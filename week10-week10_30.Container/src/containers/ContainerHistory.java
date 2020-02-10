package containers;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ContainerHistory {
    //Object attributes/instance vars
    private ArrayList<Double> history;

    //Object constructors
    public ContainerHistory(){
        this.history = new ArrayList<Double>();
    }

    //Object methods
    /*Adds all adjustments that have been made to the container*/
    public void add(double situation){
        this.history.add(situation);
    }

    /*Clears the history arrayList*/
    public void reset(){
        this.history.clear();
    }

    /*Both the maxValue and minValue functions could be much simpler.  I should have declared the
    history instance var as a List.  Doing this I could have used the Collections class on it.  This
    makes both methods 1 liner.

    maxValue
        return Collections.max(history);

    minValue
        return Collections.min(history);
     */

    /*Returns the max # from the arrayList.  If it's empty, return 0*/
    public double maxValue(){
        if(!this.history.isEmpty()){
            Set<Double> maxList = new TreeSet<Double>(this.history);

            return ((TreeSet<Double>) maxList).last();
        }

        return 0;
    }

    /*Returns the min # from the arrayList.  If it's empty, return 0*/
    public double minValue(){
        if(!this.history.isEmpty()){
            Set<Double> minList = new TreeSet<Double>(this.history);

            return ((TreeSet<Double>) minList).first();
        }

        return 0;
    }

    /*Calculates the average from the arrayList.  If it's empty, return 0*/
    public double average(){
        if(!this.history.isEmpty()){
            double ave = 0;

            for(double num : this.history){
                ave += num;
            }

            return ave / this.history.size();
        }

        return 0;
    }

    /*Returns the > fluctuations between entries.  ex set[3, 2, 7, 4].  We are checking the fluctuation
    between adjoining #'s.  Biggest is between 2 and 7 which equals 5.  Return 0 if only 1 # or < in history.
     */
    public double greatestFluctuation(){
        if(this.history.size() > 1) {
            double max = 0;
            double min = 0;

            for (int i = 0; i < this.history.size() - 1; i++) {
                min = Math.abs(this.history.get(i) - this.history.get(i + 1));

                if (min > max)
                    max = min;
            }

            return max;
        }

        return 0;
    }

    /*Returns the variance of all #'s and 0 if there is 1 # or <*/
    public double variance(){
        if(this.history.size() > 1){
            double variance = 0;

            for(double num : this.history){
                variance += Math.pow(num - average(), 2);
            }

            return variance / (this.history.size() - 1);
        }

        return 0;
    }

    @Override
    public String toString(){
        return this.history.toString();
    }
}
