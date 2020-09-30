package io.github.toandv.cardgame.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardType == card.cardType &&
                cardSuit == card.cardSuit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardSuit);
    }
}
