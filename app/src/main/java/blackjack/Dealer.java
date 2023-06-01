package blackjack;

import java.util.*;
import org.apache.commons.lang3.tuple.Pair;


public class Dealer extends Players {

    public Dealer() {
        super();
    }

    public List<Card> playTurn(List<Card> playingCards, Card dealerSecondCard, Player player) {
        System.out.println("DEALER'S FACE-DOWN CARD: " + dealerSecondCard.toString());
        while(super.getTotalCount() < 17) {
            Pair<Card, List<Card>> result = assignNewCard(playingCards);
            playingCards = result.getRight();
            System.out.println("DEALER DRAWS A: " + result.getLeft().toString());
        }
        printWinner(player.getTotalCount(), super.getTotalCount(), player);
        return playingCards;
    }

    private void printWinner(int playerTotalCount, int dealerTotalCount, Player player) {
        boolean playerBlackjack = playerTotalCount == 21 && player.getPlayerCards().size() == 2;
        boolean dealerBlackjack = dealerTotalCount == 21 && this.getPlayerCards().size() == 2;

        if (dealerTotalCount > 21) {
            if (playerTotalCount > 21) {
                System.out.println("BOTH PLAYER AND DEALER BUST! IT'S A PUSH!");
            } else {
                System.out.println("DEALER BUSTS! YOU WIN!");
            }
        } else if (dealerBlackjack && playerBlackjack) {
            System.out.println("BOTH PLAYER AND DEALER HAVE BLACKJACK! IT'S A PUSH!");
        } else if (dealerBlackjack) {
            System.out.println("DEALER HAS BLACKJACK! YOU LOSE!");
        } else if (playerBlackjack) {
            System.out.println("YOU HAVE BLACKJACK! YOU WIN!");
        } else if (playerTotalCount > dealerTotalCount) {
            System.out.println("YOUR SCORE:  " + playerTotalCount + " DEALER SCORE: " + dealerTotalCount);
            System.out.println("YOU WIN!");
        } else if (playerTotalCount < dealerTotalCount) {
            System.out.println("YOUR SCORE:  " + playerTotalCount + " DEALER SCORE: " + dealerTotalCount);
            System.out.println("YOU LOSE!");
        } else {
            System.out.println("YOUR SCORE:  " + playerTotalCount + " DEALER SCORE: " + dealerTotalCount);
            System.out.println("PUSH!");
        }
    }
}
