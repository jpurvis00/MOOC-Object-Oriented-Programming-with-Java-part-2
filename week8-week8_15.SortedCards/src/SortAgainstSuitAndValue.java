import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card> {
    public int compare(Card card1, Card card2){
        //If the suits are the same, sort it by face value
        if(card1.getSuit() == card2.getSuit())
            return card1.getValue() - card2.getValue();

        //Suits are not the same so sort by suit
        return card1.getSuit() - card2.getSuit();
    }
}
