public class Card implements Comparable<Card> {

    /*
     * These are static constant variables. These variables can be used inside and outside
     * of this class like, for example, Card.CLUBS
     */
    public static final int SPADES = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;
    /*
     * To make printing easier, Card-class also has string arrays for suits and values.
     * SUITS[suit] is a string representation of the suit (Clubs, Diamonds, Hearts, Spades)
     * VALUES[value] is an abbreviation of the card's value (A, J, Q, K, [2..10]).
     */
    public static final String[] SUITS = {"Spades", "Diamonds", "Hearts", "Clubs"};
    public static final String[] VALUES = {"-", "-", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return VALUES[value] + " of " + SUITS[suit];
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }
    
    @Override
    public int compareTo(Card card){
        if(this.value - card.getValue() == 0){
            return this.suit - card.getSuit();
        }
        return this.value - card.getValue();
    }

}


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    
    public Hand(){
        this.cards = new ArrayList<Card>();
    }
    
    public void add(Card card){
        this.cards.add(card);
    }
    
    public void print(){
        for(Card card : this.cards){
            System.out.println(card);
        }
    }
    
    public void sort(){
        Collections.sort(this.cards);
    }
    
    public int Values(){
        int sum = 0;
        for(Card card : this.cards){
            sum += card.getValue();
        }
        return sum;
    }
    
    public int Suits(){
        int sum = 0;
        for(Card card : this.cards){
            sum += card.getSuit();
        }
        return sum;
    }
    
    @Override
    public int compareTo(Hand hand){
        return this.Values() - hand.Values();
    }
    
    public void sortAgainstSuit(){
        Collections.sort(this.cards, new SortAgainstSuitAndValue());
    }
}


import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card>{
    public int compare(Card card, Card myCard){
        if(card.getSuit() - myCard.getSuit() == 0){
            return card.getValue() - myCard.getValue();
        }
        return card.getSuit() - myCard.getSuit();
    }
}
