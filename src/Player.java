import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private int points;

    private String name;

    // Constructor
    public Player(String name) {
        this.name = name;
        points = 0;
        hand = new ArrayList<>();
    }

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        points = 0;
        this.hand = new ArrayList<>();
        this.hand.addAll(hand);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int numPoints) {
        points += numPoints;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public String toString() {
        return name + " has " + points + " points\n" + name + "'s cards: " + hand;
    }
}
