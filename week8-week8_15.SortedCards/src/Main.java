import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*Card first = new Card(2, Card.DIAMONDS);
        Card second = new Card(14, Card.CLUBS);
        Card third = new Card(12, Card.HEARTS);
        Card fourth = new Card(2, Card.HEARTS);
        Card fifth = new Card(2, Card.CLUBS);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(fifth);

        List<Card> hand = new ArrayList<Card>();
        hand.add(first);
        hand.add(second);
        hand.add(third);
        hand.add(fourth);
        hand.add(fifth);

        Collections.sort(hand);
        System.out.println(hand);

        Hand hand = new Hand();

        hand.add( new Card(2, Card.SPADES) );
        hand.add( new Card(14, Card.CLUBS) );
        hand.add( new Card(12, Card.HEARTS) );
        hand.add( new Card(2, Card.CLUBS) );

        hand.sort();

        hand.print();

        Hand hand1 = new Hand();

        hand1.add( new Card(2, Card.SPADES) );
        hand1.add( new Card(14, Card.CLUBS) );
        hand1.add( new Card(12, Card.HEARTS) );
        hand1.add( new Card(2, Card.CLUBS) );

        Hand hand2 = new Hand();

        hand2.add( new Card(11, Card.DIAMONDS) );
        hand2.add( new Card(11, Card.CLUBS) );
        hand2.add( new Card(11, Card.HEARTS) );

        int comparison = hand1.compareTo(hand2);

        if ( comparison < 0 ) {
            System.out.println("the most valuable hand contains the cards");
            hand2.print();
        } else if ( comparison > 0 ){
            System.out.println("the most valuable hand contains the cards");
            System.out.println(comparison);
            hand1.print();
        } else {
            System.out.println("the hands are equally valuable");
        }

        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add( new Card(3, Card.CLUBS) );
        cards.add( new Card(2, Card.DIAMONDS) );
        cards.add( new Card(14, Card.CLUBS) );
        cards.add( new Card(12, Card.HEARTS) );
        cards.add( new Card(2, Card.CLUBS) );

        SortAgainstSuit suitSorter = new SortAgainstSuit();
        Collections.sort(cards, suitSorter );

        for (Card c : cards) {
            System.out.println( c );
        }*/

        Hand hand = new Hand();

        hand.add( new Card(12, Card.HEARTS) );
        hand.add( new Card(4, Card.CLUBS) );
        hand.add( new Card(2, Card.DIAMONDS) );
        hand.add( new Card(14, Card.CLUBS) );
        hand.add( new Card(7, Card.HEARTS) );
        hand.add( new Card(2, Card.CLUBS) );

        hand.sortAgainstSuit();

        hand.print();
    }
}
