package blackjack;

import java.util.*;

public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();

        for(Card.Suit suit : Card.Suit.values()) {
            for(Card.Rank rank : Card.Rank.values()) {
                Card card = new Card(suit, rank);
                this.deck.add(card);
            }
        }
    }

    public List<Card> getDeck() {
        return this.deck;
    }

}
