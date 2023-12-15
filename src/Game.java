import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Instance variables
    // Content Standard: "Declare, initialize and assign a value to a variable, be it a primitive or object"
    // Content Standard: "Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately"
    // Content Standard: "Can declare and initialize Arrays, ArrayLists, and 2D Arrays"
    private Deck deck;
    private ArrayList<Player> players;
    private Card topCard;
    // Global variable so I can to access the # of players across all methods
    // Content Standard: "Can utilize class-scope instance variables and local parameters in methods"
    private int numPlayers;
    // Initialize the scanner
    Scanner input = new Scanner(System.in);

    public Game() {
        // Initialize Deck
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        deck = new Deck(ranks, suits, values);

        // Add a single card to topCard to act as a starting card
        topCard = deck.deal();

        // Ask the user for the amount of players playing
        System.out.println("Enter the number of players: ");
        numPlayers = input.nextInt();
        input.nextLine();
        players = new ArrayList<Player>();

        // Ask the player(s) for their names
        // Initializing players
        for (int j = 0; j < numPlayers; j++) {
            System.out.println("Name of player " + (j + 1) + ":");
            String namePlayer = input.nextLine();
            players.add(new Player(namePlayer));
        }

        // Distributing 5 cards to all the players
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < 5; j++) {
                players.get(i).addCard(deck.deal());
            }
        }
    }


    public void playGame() {
         boolean isWinner = false;
         // If the starting cards has a rank of eight, deal a new card to it
        // Content Standard: "Can use ArrayList methods"
         if (topCard.getRanks().equals("8")) {
             topCard = deck.deal();
         }

        // Content Standard: "Can use if, while, and for"
        // Content Standard: "Can use ArrayList methods"
        while (!isWinner()) {
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("");
                // Print the top card (most recent card) that was played
                System.out.println("The top card is " + topCard);
                // Print the hand of the player so they can see all their cards
                System.out.println("Player " + (i + 1) + "'s hand: " + players.get(i).getHand() + " Draw");
                int numPlayer = i;
                // Asking what card the player wants to play, or draw from the deck
                System.out.println("Which card would you like to play or draw? ");
                int indexCard = input.nextInt();
                input.nextLine();
                // Determines whether or not the player wants to play a card or draw
                if (indexCard < players.get(i).getHand().size() - 1) {
                    // Calling on the isMatch() method to determine whether or not the player's card is valid
                    if (isMatch(indexCard, numPlayer)) {
                        // Removing the card from the player's hand
                        players.get(numPlayer).getHand().remove(indexCard);
                        continue;
                    }
                    // Penalize the player for choosing an invalid card
                    else {
                        players.get(i).addCard(deck.deal());
                        continue;
                    }
                }
                // If the player chooses the draw option add a card to the deck
                else {
                    players.get(i).addCard(deck.deal());
                    continue;
                }
            }
        }
    }

    public boolean isMatch(int indexCard, int numPlayer) {
        // Compares the rank and suite of the top card to the card the player wants to play
        // Content Standard: "Can use ArrayList methods"
        if (topCard.getRanks().equals(players.get(numPlayer).getHand().get(indexCard)) || topCard.getSuits().equals(players.get(numPlayer).getHand().get(indexCard))) {
            // Sets the top card to the card the player just placed
            topCard = players.get(numPlayer).getHand().get(indexCard);
            return true;
        }
        return false;
    }

    // Checks if the game is won if a player has no remaining cards in their hand
    public boolean isWinner() {
        // If a player has no cards in their hands return true
        for (int i = 0; i < numPlayers; i++) {
            // Content Standard: "Can use ArrayList methods"
            if (players.get(i).getHand().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Instructions to Crazy8
    public void printInstructions() {
        System.out.println("Welcome to Crazy8!");
        System.out.println("The goal of the game is to be the first player to have no cards in their hand. ");
        System.out.println("You can get rid of your cards if it matches the rank or suite of the top card. ");
        System.out.println("If there is no match in your hand, you must draw a new card and forfeit your turn. ");
        System.out.println("Have Fun!");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printInstructions();
        game.playGame();
    }
}