package io.github.toandv.cardgame;

import io.github.toandv.cardgame.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    @Test
    public void testWinnerWithTrail() {
        CardDeck cardDeck = mock(CardDeck.class);

        // winner should be player 1 with 3 ACEs
        when(cardDeck.getFirstCard()).thenReturn(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.SEVEN, CardSuit.HEARTS),
                new Card(CardType.JACK, CardSuit.CLOVES),

                new Card(CardType.ACE, CardSuit.TILES),
                new Card(CardType.THREE, CardSuit.HEARTS),
                new Card(CardType.SEVEN, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.CLOVES),

                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.FOUR, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.TILES),
                new Card(CardType.KING, CardSuit.CLOVES)
        );

        Game game = new Game(4, cardDeck);
        game.play();
        assertTrue(game.hasWinner());
        assertEquals(1, game.getWinner().getPlayerId());
        assertEquals(new HashSet<>(Arrays
                        .asList(new Card(CardType.ACE, CardSuit.CLOVES),
                                new Card(CardType.ACE, CardSuit.TILES),
                                new Card(CardType.ACE, CardSuit.HEARTS))),
                new HashSet<>(game.getWinner().getDealtCards()));
    }

    @Test
    public void testWinnerWithSequence() {
        CardDeck cardDeck = mock(CardDeck.class);

        // winner should be player 4 with a sequence of J,Q,K
        when(cardDeck.getFirstCard()).thenReturn(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.SEVEN, CardSuit.HEARTS),
                new Card(CardType.JACK, CardSuit.CLOVES),

                new Card(CardType.TWO, CardSuit.TILES),
                new Card(CardType.THREE, CardSuit.HEARTS),
                new Card(CardType.SEVEN, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.CLOVES),

                new Card(CardType.THREE, CardSuit.HEARTS),
                new Card(CardType.FOUR, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.TILES),
                new Card(CardType.KING, CardSuit.CLOVES)
        );

        Game game = new Game(4, cardDeck);
        game.play();
        assertTrue(game.hasWinner());
        assertEquals(4, game.getWinner().getPlayerId());
        assertEquals(new HashSet<>(Arrays
                        .asList(new Card(CardType.JACK, CardSuit.CLOVES),
                                new Card(CardType.QUEEN, CardSuit.CLOVES),
                                new Card(CardType.KING, CardSuit.CLOVES))),
                new HashSet<>(game.getWinner().getDealtCards()));
    }

    @Test
    public void testWinnerWithPair() {
        CardDeck cardDeck = mock(CardDeck.class);

        // winner should be player 3 with a pair of J and TEN
        when(cardDeck.getFirstCard()).thenReturn(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.PIKES),

                new Card(CardType.FOUR, CardSuit.TILES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.TILES),

                new Card(CardType.THREE, CardSuit.HEARTS),
                new Card(CardType.TEN, CardSuit.CLOVES),
                new Card(CardType.JACK, CardSuit.TILES),
                new Card(CardType.QUEEN, CardSuit.CLOVES)
        );

        Game game = new Game(4, cardDeck);
        game.play();
        assertTrue(game.hasWinner());
        assertEquals(3, game.getWinner().getPlayerId());
        assertEquals(new HashSet<>(Arrays
                        .asList(new Card(CardType.TEN, CardSuit.HEARTS),
                                new Card(CardType.JACK, CardSuit.CLOVES),
                                new Card(CardType.JACK, CardSuit.TILES))),
                new HashSet<>(game.getWinner().getDealtCards()));
    }

    @Test
    public void testWinnerFromTiedPlayers() {
        CardDeck cardDeck = mock(CardDeck.class);

        // winner should be player 3 with a pair of J and TEN
        when(cardDeck.getFirstCard()).thenReturn(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.THREE, CardSuit.HEARTS),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.PIKES),

                new Card(CardType.FOUR, CardSuit.TILES),
                new Card(CardType.FOUR, CardSuit.HEARTS),
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.TILES),

                new Card(CardType.FIVE, CardSuit.HEARTS),
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.JACK, CardSuit.TILES),
                new Card(CardType.QUEEN, CardSuit.CLOVES)
        );

        // two tied players must draw twice, the final winner draws an ACE and wins
        when(cardDeck.getRandomCard()).thenReturn(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.FIVE, CardSuit.HEARTS),

                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.KING, CardSuit.HEARTS)
        );

        when(cardDeck.hasEnoughCards(2)).thenReturn(true);

        Game game = new Game(4, cardDeck);
        game.play();
        assertTrue(game.hasWinner());
        assertEquals(new HashSet<>(Arrays
                        .asList(new Card(CardType.FIVE, CardSuit.CLOVES),
                                new Card(CardType.ACE, CardSuit.CLOVES))),
                new HashSet<>(game.getWinner().getDrawnCards()));
    }


}
