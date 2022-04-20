package wargame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class War {

    CardDeck deck = new CardDeck();
    Player player1;
    Player player2;

    War(){
        player1 = null;
        player2 = null;
        showMenu();
    }

    private void showMenu(){
        System.out.println("================= War ================\n Option \t\t\t Action \n 1 \t\t\t Add Players " +
                "\n 2 \t\t\t Start Game");

        String option = new Scanner(System.in).nextLine();

        switch (option){
            case "1":
                createPlayers();
                break;
            case "2":
                startMatch();
                break;
            default:
                System.out.println("\n Invalid Option \n");
                showMenu();
                break;
        }
    }

    private void startMatch() {
        distribute();

        Card p1Card = player1.playCard();
        Card p2Card = player2.playCard();

        while (true) {
            ArrayList<Card> playedCards = new ArrayList<>();
            playedCards.add(p1Card);
            playedCards.add(p2Card);

            System.out.println(player1.cards.size() + " " + player2.cards.size());

            if (player1.getScore() > player2.getScore()) {
                System.out.println("Player 1 Wins!");
                break;
            } else if (player2.getScore() > player1.getScore()) {
                System.out.println("Player 2 Wins!");
                break;
            }
            if(p1Card == null)
            {
                System.out.println("Player 2 Wins!");
            }
            else if(p2Card == null)
            {
                System.out.println("Player 1 Wins!");
            }
            if (p1Card.getSuit() < p2Card.getSuit()) {
                playedCards.forEach(card -> player2.addCard(card));
            }
            if (p1Card.getSuit() > p2Card.getSuit()) {
                playedCards.forEach(card -> player1.addCard(card));
            }else{
                playedCards.add(player1.playCard());
                playedCards.add(player2.playCard());
            }

            p1Card = player1.playCard();
            p2Card = player2.playCard();

        }
    }

    private void distribute(){
        Stack<Card> cards = deck.shuffleCards();
        System.out.println(cards.size());
        for (int i = 0; i < cards.size(); i++) {
            player1.addCard(cards.pop());
            player2.addCard(cards.pop());
        }
    }

    private void createPlayers(){
        System.out.println("\nEnter Player 1 Name: ");
        String name = new Scanner(System.in).nextLine();
        player1 = new Player(name);

        System.out.println("\nEnter Player 2 Name: ");
        name = new Scanner(System.in).nextLine();
        player2 = new Player(name);
        System.out.println("Done!");
        showMenu();
    }

    public static void main(String[] args) {
        War wargame = new War();
    }
}
