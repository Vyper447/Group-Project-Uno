package wargame;

public class Card {
    private int suit;
    private String rank;

    
    Card(int suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

   
    public int getSuit() {
        return suit;
    }

   
    public void setSuit(int number) {
        this.suit = number;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String value) {
        this.rank = value;
    }

}