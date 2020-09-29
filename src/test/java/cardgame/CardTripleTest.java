package cardgame;

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
                        new Card(CardType.ACE, Suit.CLOVES),
                        new Card(CardType.ACE, Suit.HEARTS),
                        new Card(CardType.ACE, Suit.TILES)),
                new CardTriple(
                        new Card(CardType.TWO, Suit.CLOVES),
                        new Card(CardType.TWO, Suit.HEARTS),
                        new Card(CardType.TWO, Suit.TILES)),
                new CardTriple(
                        new Card(CardType.KING, Suit.CLOVES),
                        new Card(CardType.KING, Suit.HEARTS),
                        new Card(CardType.KING, Suit.TILES))
        );
    }


    static Stream<CardTriple> sequenceCards() {
        return Stream.of(
                new CardTriple(
                        new Card(CardType.ACE, Suit.CLOVES),
                        new Card(CardType.TWO, Suit.HEARTS),
                        new Card(CardType.THREE, Suit.TILES)),
                new CardTriple(
                        new Card(CardType.JACK, Suit.CLOVES),
                        new Card(CardType.QUEEN, Suit.HEARTS),
                        new Card(CardType.KING, Suit.TILES)),
                new CardTriple(
                        new Card(CardType.FIVE, Suit.CLOVES),
                        new Card(CardType.SIX, Suit.HEARTS),
                        new Card(CardType.SEVEN, Suit.TILES))
        );
    }

    static Stream<CardTriple> pairCards() {
        return Stream.of(
                new CardTriple(
                        new Card(CardType.ACE, Suit.CLOVES),
                        new Card(CardType.ACE, Suit.HEARTS),
                        new Card(CardType.THREE, Suit.TILES)),
                new CardTriple(
                        new Card(CardType.JACK, Suit.CLOVES),
                        new Card(CardType.JACK, Suit.HEARTS),
                        new Card(CardType.KING, Suit.TILES)),
                new CardTriple(
                        new Card(CardType.FIVE, Suit.CLOVES),
                        new Card(CardType.SEVEN, Suit.HEARTS),
                        new Card(CardType.SEVEN, Suit.TILES))
        );
    }

    static Stream<CardTriple> noPatternCards() {
        return Stream.of(
                new CardTriple(
                        new Card(CardType.ACE, Suit.CLOVES),
                        new Card(CardType.FOUR, Suit.HEARTS),
                        new Card(CardType.THREE, Suit.TILES)),
                new CardTriple(
                        new Card(CardType.JACK, Suit.CLOVES),
                        new Card(CardType.FIVE, Suit.HEARTS),
                        new Card(CardType.KING, Suit.TILES)),
                new CardTriple(
                        new Card(CardType.FIVE, Suit.CLOVES),
                        new Card(CardType.TWO, Suit.HEARTS),
                        new Card(CardType.SEVEN, Suit.TILES))
        );
    }

}
