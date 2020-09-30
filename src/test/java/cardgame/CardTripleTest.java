package cardgame;

import cardgame.model.Card;
import cardgame.model.CardSuit;
import cardgame.model.CardTriple;
import cardgame.model.CardType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTripleTest {

    @ParameterizedTest
    @MethodSource("trailCards")
    void testTrailPattern(CardTriple cardTriple) {
        assertTrue(cardTriple.isTrail());
        assertFalse(cardTriple.isSequence());
        assertFalse(cardTriple.isHasPair());
    }

    @ParameterizedTest
    @MethodSource("sequenceCards")
    void testSequencePattern(CardTriple cardTriple) {
        assertFalse(cardTriple.isTrail());
        assertTrue(cardTriple.isSequence());
        assertFalse(cardTriple.isHasPair());
    }

    @ParameterizedTest
    @MethodSource("pairCards")
    void testPairPattern(CardTriple cardTriple) {
        assertFalse(cardTriple.isTrail());
        assertFalse(cardTriple.isSequence());
        assertTrue(cardTriple.isHasPair());
    }

    @ParameterizedTest
    @MethodSource("noPatternCards")
    void testNoPattern(CardTriple cardTriple) {
        assertFalse(cardTriple.isTrail());
        assertFalse(cardTriple.isSequence());
        assertFalse(cardTriple.isHasPair());
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
