package cardgame.model;

public class Card {

    private final CardType cardType;

    private final CardSuit cardSuit;

    public Card(CardType cardType, CardSuit cardSuit) {
        this.cardType = cardType;
        this.cardSuit = cardSuit;
    }

    public CardSuit getSuit() {
        return cardSuit;
    }

    public int getValue() {
        return cardType.getValue();
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getTopCardOrder() {
        return cardType.getTopCardOrder();
    }

    public int getScore() {
        return cardType.getTopCardOrder();
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardName=" + cardType.name() +
                ", suit=" + cardSuit.name() +
                '}';
    }
}
