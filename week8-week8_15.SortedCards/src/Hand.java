import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    //Object attributes/vars
    private List<Card> hand;

    //Object constructors
    public Hand(){
        this.hand = new ArrayList<Card>();
    }

    //Object methods
    //Adds a card to the arrayList
    public void add(Card card){
        this.hand.add(card);
    }

    //Prints all cards in the arrayList
    public void print(){
        for(Card card : this.hand){
            System.out.println(card);
        }
    }

    //Sorts the cards in the arrayList by face value.  Does not look at suit
    public void sort(){
        Collections.sort(this.hand);
    }

    //Sort hand by suit
    public void sortAgainstSuit(){
        Collections.sort(this.hand, new SortAgainstSuitAndValue());
    }

    /*Allows us to compare 2 hands and returns the hand with the largest value.  This is done by
    adding the numeric values of all cards in the hand.  Returns a 0 if they are equal, < 0 if the passed in
    object is >, and > 0 if this object is >.
     */
    @Override
    public int compareTo(Hand hand){
        int hand1Total = 0;
        int hand2Total = 0;

        //Find the card total for this objects hand
        for(Card hand1 : this.hand){
            hand1Total += hand1.getValue();
        }

        //Find the card total for the passed in hand
        for(Card hand2 : hand.hand){
            hand2Total += hand2.getValue();
        }

        return hand1Total - hand2Total;
    }
}
