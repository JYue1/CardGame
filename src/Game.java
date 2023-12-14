import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private Card topCard;
    // Global variable so I am able to access the # of players
    private int numPlayers;
    Scanner input = new Scanner(System.in);

    public void printInstructions() {
        System.out.println("Welcome to Crazy8");
    }

    public Game() {

        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        deck = new Deck(ranks, suits, values);

        topCard = deck.deal();

        System.out.println("Enter the number of players: ");
        numPlayers = input.nextInt();
        input.nextLine();
        players = new ArrayList<Player>();

        // for loop for all the players
        System.out.println("What is your name? ");
        String namePlayer = input.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(namePlayer));
        }

        // I'm going into the deck card and dealing a card (returning a card to the player)
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < 5; j++) {
                players.get(i).addCard(deck.deal());
            }
        }
    }

    public void playGame() {
         boolean isWinner = false;

         if (topCard.getRanks().equals("8")) {
             topCard = deck.deal();
         }
         System.out.println(topCard);

        while (!isWinner()) {
            for (int i = 0; i < numPlayers; i++) {
                System.out.println(players.get(i).getHand());
                int numPlayer = i;
                System.out.println("What card would you like to play? ");
                int indexCard = input.nextInt();
                input.nextLine();
                if (indexCard < 5) {
                    if (isMatch(indexCard, numPlayer) == true) {
                        continue;
                    }
                }
                else {
                    players.get(i).addCard(deck.deal());
                    continue;
                }
            }
        }
    }

    public boolean isMatch(int indexCard, int numPlayer) {
        if (topCard.getRanks().equals(players.get(numPlayer).getHand().get(indexCard)) || topCard.getSuits().equals(players.get(numPlayer).getHand().get(indexCard))) {
            topCard = players.get(numPlayer).getHand().get(indexCard);
            return true;
        }
        return false;
    }

    public boolean isWinner() {
        // If a player has no cards in their hands return true
        for (int i = 0; i < numPlayers; i++) {
            if (players.get(i).getHand().size() == 0) { //maybe isEmpty()
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Game g1 = new Game();
        g1.playGame();
    }
}