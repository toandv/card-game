package io.github.toandv.cardgame;

import cardgame.model.*;
import io.github.toandv.cardgame.model.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CardTripleTest {

    @ParameterizedTest
    @MethodSource("trailCards")
    void testTrailPattern(CardTriple cardTriple) {
        assertEquals(CardTriplePattern.TRAIL, cardTriple.getPattern());
    }

    @ParameterizedTest
    @MethodSource("sequenceCards")
    void testSequencePattern(CardTriple cardTriple) {
        assertEquals(CardTriplePattern.SEQUENCE, cardTriple.getPattern());
    }

    @ParameterizedTest
    @MethodSource("pairCards")
    void testPairPattern(CardTriple cardTriple) {
        assertEquals(CardTriplePattern.PAIR, cardTriple.getPattern());
    }

    @ParameterizedTest
    @MethodSource("noPatternCards")
    void testNoPattern(CardTriple cardTriple) {
        assertEquals(CardTriplePattern.NO_PATTERN, cardTriple.getPattern());
    }

    static Stream<CardTriple> trailCards() {
        return Stream.of(
                new CardTriple(
                        new Card(CardType.ACE, CardSuit.CLOVES),
                        new Card(CardType.ACE, CardSuit.HEARTS),
                        new Card(CardType.ACE, CardSuit.TILES)),
                new CardTriple(
                        new Card(CardType.TWO, CardSuit.CLOVES),
                        new Card(CardType.TWO, CardSuit.HEARTS),
                        new Card(CardType.TWO, CardSuit.TILES)),
                new CardTriple(
                        new Card(CardType.KING, CardSuit.CLOVES),
                        new Card(CardType.KING, CardSuit.HEARTS),
                        new Card(CardType.KING, CardSuit.TILES))
        );
    }


    static Stream<CardTriple> sequenceCards() {
        return Stream.of(
                new CardTriple(
                        new Card(CardType.ACE, CardSuit.CLOVES),
                        new Card(CardType.TWO, CardSuit.HEARTS),
                        new Card(CardType.THREE, CardSuit.TILES)),
                new CardTriple(
                        new Card(CardType.JACK, CardSuit.CLOVES),
                        new Card(CardType.QUEEN, CardSuit.HEARTS),
                        new Card(CardType.KING, CardSuit.TILES)),
                new CardTriple(
                        new Card(CardType.FIVE, CardSuit.CLOVES),
                        new Card(CardType.SIX, CardSuit.HEARTS),
                        new Card(CardType.SEVEN, CardSuit.TILES))
        );
    }

    static Stream<CardTriple> pairCards() {
        return Stream.of(
                new CardTriple(
                        new Card(CardType.ACE, CardSuit.CLOVES),
                        new Card(CardType.ACE, CardSuit.HEARTS),
                        new Card(CardType.THREE, CardSuit.TILES)),
                new CardTriple(
                        new Card(CardType.JACK, CardSuit.CLOVES),
                        new Card(CardType.JACK, CardSuit.HEARTS),
                        new Card(CardType.KING, CardSuit.TILES)),
                new CardTriple(
                        new Card(CardType.FIVE, CardSuit.CLOVES),
                        new Card(CardType.SEVEN, CardSuit.HEARTS),
                        new Card(CardType.SEVEN, CardSuit.TILES))
        );
    }

    static Stream<CardTriple> noPatternCards() {
        return Stream.of(
                new CardTriple(
                        new Card(CardType.ACE, CardSuit.CLOVES),
                        new Card(CardType.FOUR, CardSuit.HEARTS),
                        new Card(CardType.THREE, CardSuit.TILES)),
                new CardTriple(
                        new Card(CardType.JACK, CardSuit.CLOVES),
                        new Card(CardType.FIVE, CardSuit.HEARTS),
                        new Card(CardType.KING, CardSuit.TILES)),
                new CardTriple(
                        new Card(CardType.FIVE, CardSuit.CLOVES),
                        new Card(CardType.TWO, CardSuit.HEARTS),
                        new Card(CardType.SEVEN, CardSuit.TILES))
        );
    }
}
