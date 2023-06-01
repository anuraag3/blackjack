package blackjack;

import java.util.*;
import org.apache.commons.lang3.tuple.Pair;

public abstract class Players {
    
    private int totalCount;
    private List<Card> playerCards;

    protected Players() {
        this.totalCount = 0;
        playerCards = new ArrayList<>();
    }

    public int getTotalCount() {
        int total = 0;
        int aces = 0;

        for (Card card : playerCards) {
            switch (card.getRank()) {
                case ACE: total += 11; aces++; break;
                case KING: case QUEEN: case JACK: case TEN: total += 10; break;
                default: total += card.getRank().getValue(); break;
            }
        }
        
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        totalCount = total;
        return total;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public Pair<Card, List<Card>> assignNewCard(List<Card> playingCards) {
        Card card = playingCards.remove(0);
        playerCards.add(card);
        totalCount = getTotalCount();
        return Pair.of(card, playingCards);
    }


    public String getTotalCountWithAceOptions() {
        int aces = (int) playerCards.stream().filter(card -> card.getRank() == Card.Rank.ACE).count();
        if (aces > 0) {
            return totalCount + " OR " + (totalCount - 10 * aces);
        } else {
            return String.valueOf(totalCount);
        }
    }

    public int getFirstCardCount() {
        int total = 0;
        int aces = 0;
        Card firstCard = playerCards.get(0);
    
        switch (firstCard.getRank()) {
            case ACE: total += 11; aces++; break;
            case KING: case QUEEN: case JACK: case TEN: total += 10; break;
            default: total += firstCard.getRank().getValue(); break;
        }
    
        return total;
    }


}