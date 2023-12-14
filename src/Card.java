public class Card {
    private String ranks;
    private String suits;
    private int values;

    public Card(String ranks, String suits, int values) {
        this.ranks = ranks;
        this.suits = suits;
        this.values = values;
    }

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

    // public boolean cardOther()
    // return if suit (.equals)

    public String toString(){
        return ranks + " of " + suits;
    }
}