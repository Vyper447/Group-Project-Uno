package wargame;

import java.util.*;

public class CardDeck {
    private ArrayList<Card> deck = new ArrayList<>(52);

    CardDeck() {
        String[] shapes = {"Spade", "Club", "Diamond", "Heart"};
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 14; i++) {
                String value = (i == 1 ? "ACE" : i == 11 ? "JACK" : i == 12 ? "QUEEN" : i == 13 ? "KING" :
                        Integer.toString(i)) + " of " + shapes[j];

                deck.add(new Card(i, value));
            }
        }
    }

    /**
     * Shuffle Cards
     * @return Stack of shuffled cards
     * @see Stack Stack
     */
    public Stack<Card> shuffleCards( ) {
        Collections.shuffle(deck);
        Stack<Card> shuffledCards = new Stack<>();
        shuffledCards.addAll(deck);
        return shuffledCards;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}

