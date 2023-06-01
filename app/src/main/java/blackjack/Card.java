package blackjack;

public class Card {
    public enum Suit {
        SPADE, CLUB, DIAMOND, HEART
    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
    
        private int value;
    
        public int getValue() {
            return this.value;
        }

        private Rank(int value) {
            this.value = value;
        }
    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return rank.toString() + " " + (suit.toString());
    }
}
