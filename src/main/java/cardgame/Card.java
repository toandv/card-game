package cardgame;

public class Card {

    private CardType cardType;

    private Suit suit;

    public Card(CardType cardType, Suit suit) {
        this.cardType = cardType;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return cardType.getValue();
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getScore() {
        return cardType.getScore();
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardName=" + cardType.name() +
                ", suit=" + suit.name() +
                '}';
    }
}
