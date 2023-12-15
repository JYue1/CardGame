public class Card {
    // Instance variables (attributes of a card)
    // Content Standard: "Declare, initialize and assign a value to a variable, be it a primitive or object"
    // Content Standard: "Can write a class containing instance variables, constructors, and methods, using access modifiers (private vs public) appropriately"
    private String ranks;
    private String suits;
    private int values;

    // Constructor that takes in 3 parameters
    public Card(String ranks, String suits, int values) {
        this.ranks = ranks;
        this.suits = suits;
        this.values = values;
    }

    // Below: getters and setters for each instance variable
    // Content Standards: "Can write methods, including accessors (getters) and mutators (setters), with correct return types"
    public String getRanks() {
        return ranks;
    }

    public void setRanks(String ranks) {
        this.ranks = ranks;
    }

    public String getSuits() {
        return suits;
    }

    public void setSuits(String suits) {
        this.suits = suits;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

    // Format of toString (Ex. "Jack of Clubs")
    public String toString(){
        return ranks + " of " + suits;
    }
}