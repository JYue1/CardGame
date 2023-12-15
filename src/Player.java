import java.util.ArrayList;

public class Player {
    // Instance variables
    // Content Standard: "Declare, initialize and assign a value to a variable, be it a primitive or object"
    // Content Standard: "Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately"
    // Content Standard: "Can declare and initialize Arrays, ArrayLists, and 2D Arrays"
    private ArrayList<Card> hand;
    private int points;
    private String name;

    // First constructor takes in name and sets points to 0
    public Player(String name) {
        this.name = name;
        points = 0;
        hand = new ArrayList<>();
    }

    // Second constructors takes in name, hand of cards, and sets points to 0
    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        points = 0;
        this.hand = new ArrayList<>();
        this.hand.addAll(hand);
    }

    // Below: getter methods for instance variables
    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    // This method allows points to be added to a player's existing points
    public void addPoints(int numPoints) {
        points += numPoints;
    }

    // Take a Card and add it to the player's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    public String toString() {
        return name + " has " + points + " points\n" + name + "'s cards: " + hand;
    }
}
