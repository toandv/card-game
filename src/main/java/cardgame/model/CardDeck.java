package cardgame.model;

import cardgame.exception.OutOfCardException;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class CardDeck {

    private final LinkedList<Card> cards;

    private final Random random = new Random();

    public CardDeck(Collection<Card> cards) {
        this.cards = new LinkedList<>(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards, random);
    }

    public Card getFirstCard() {
        ensureCardAvailability();
        return cards.removeFirst();
    }

    public Card getRandomCard() {
        ensureCardAvailability();
        int randomCardIndex = random.nextInt(cards.size());
        return cards.remove(randomCardIndex);
    }

    private void ensureCardAvailability() {
        if (cards.isEmpty()) {
            throw new OutOfCardException("No card left");
        }
    }

    public boolean hasCardsToDeal(int neededCards) {
        return cards.size() >= neededCards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
