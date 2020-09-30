package io.github.toandv.cardgame.model;

import java.util.List;

public interface CardDeck {

    void shuffle();

    Card getFirstCard();

    Card getRandomCard();

    List<Card> getCards();

    boolean hasEnoughCards(int neededCards);

}
