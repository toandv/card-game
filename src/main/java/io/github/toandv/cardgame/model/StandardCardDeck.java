package io.github.toandv.cardgame.model;

import io.github.toandv.cardgame.exception.OutOfCardException;

import java.util.*;

public class StandardCardDeck implements CardDeck {

    private final LinkedList<Card> cards;

    private final Random random = new Random();

    public StandardCardDeck(Collection<Card> cards) {
        this.cards = new LinkedList<>(cards);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards, random);
    }

    @Override
    public Card getFirstCard() {
        ensureCardAvailability();
        return cards.removeFirst();
    }

    @Override
    public Card getRandomCard() {
        ensureCardAvailability();
        int randomCardIndex = random.nextInt(cards.size());
        return cards.remove(randomCardIndex);
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    private void ensureCardAvailability() {
        if (cards.isEmpty()) {
            throw new OutOfCardException("No card left");
        }
    }

    public boolean hasEnoughCards(int neededCards) {
        return cards.size() >= neededCards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
