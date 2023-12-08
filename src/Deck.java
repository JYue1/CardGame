import java.util.ArrayList;
import java.lang.Math;
public class Deck {
    // Math.random you want to multiply by a variable because the amount of cards decreases when you deal them out
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<>();
        for (int i = 0; i < ranks.length; i++) {  // enhanced for-loop
            for (int j = 0; j < suits.length; j++) {
                Card card = new Card(ranks[i], suits[j], values[i]);
                cards.add(card);
            }
        }
        cardsLeft = cards.size();
        shuffle();
    }

    public boolean isEmpty() {
        return (cardsLeft == 0);
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal(){
        if (cards.isEmpty()) {
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }

    public void shuffle() {
        cardsLeft = cards.size();
        for (int i = cardsLeft; i >= 0; i--) {
            int randomIndex = (int) (Math.random() * cardsLeft);
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }

    }
}










// }
