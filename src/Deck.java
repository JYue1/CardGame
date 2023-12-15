import java.util.ArrayList;
import java.lang.Math;

public class Deck {
    // Instance variables for the ArrayList of cards and the number of cardsLeft
    // Content Standard: "Declare, initialize and assign a value to a variable, be it a primitive or object"
    // Content Standard: "Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately"
    // Content Standard: "Can declare and initialize Arrays, ArrayLists, and 2D Arrays"
    private ArrayList<Card> cards;
    private int cardsLeft;

    // Constructor receives three arrays as parameters
    public Deck(String[] ranks, String[] suits, int[] values) {
        // Initialize the instance variable cards
        cards = new ArrayList<>();
        // Add the cards to the list of card
        for (int i = 0; i < ranks.length; i++) {  // enhanced for-loop
            for (int j = 0; j < suits.length; j++) {
                Card card = new Card(ranks[i], suits[j], values[i]);
                cards.add(card);
            }
        }
        // Set cardsLeft to the number of cards in the deck.
        cardsLeft = cards.size();
        // Shuffle the cards in the deck by calling the shuffle method
        shuffle();
    }

    // Return true when the number of cards left in the deck is 0
    public boolean isEmpty() {
        return (cardsLeft == 0);
    }

    // Return the number of cards left in the deck
    // Content Standards: "Can write methods, including accessors (getters) and mutators (setters), with correct return types"
    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal(){
        // Content Standard: "Can use ArrayList methods"
        if (cards.isEmpty()) {
            return null;
        }
        // Subtract a card from the deck when a card is dealt
        cardsLeft--;
        // Return a player a card
        return cards.get(cardsLeft);
    }

    // Reorder the cards in the deck
    public void shuffle() {
        cardsLeft = cards.size();
        // Swapping all the indices of cards randomly
        for (int i = cardsLeft - 1; i >= 0; i--) {
            // Content Standard: "Can use Math class, especially Math.random()"
            int randomIndex = (int) (Math.random() * cardsLeft);
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }

    }
}