package wargame;

import java.util.Stack;

public class Player {
    private int score;
    private String name;
    protected Stack<Card> cards ;

    /**
     * Creates a new player
     * @param name name of player
     */
    Player(String name){
        this.name = name;
        this.score = 0;
        cards = new Stack<>();
    }

    public boolean canWin(){
        return cards.size() >= 52;
    }

   
    public int getScore() {
        return score;
    }

    /**
     * @return player's name
     */
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public void setScore(int score) {
        this.score = score;
    }

  
    public void incrementScore(){
        score += 1;
    }

    
    public void addCard(Card card){
        cards.add(card);
    }

   
    public void removeCard(int cardIndex){
        cards.remove(cardIndex);
    }

    public Card playCard(){
        if(cards.isEmpty()) return null;

        Card c = cards.pop();
        System.out.println("\n" + name + " Played: \n" + c.getRank());
        return c;
    }

    /**
     * @return list of cards that player has
     * @see java.util.ArrayList ArrayList
     */
    public Stack<Card> getCards() {
        return cards;
    }

}

