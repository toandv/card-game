package cardgame;

import java.util.*;

public class Deck {

    private LinkedList<Card> cards;

    public Deck(Collection<Card> cards) {
        this.cards = new LinkedList<>(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card takeCard() {
        if (cards.isEmpty()) {
            throw new OutOfCardException("No card left");
        }
        return cards.poll();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
