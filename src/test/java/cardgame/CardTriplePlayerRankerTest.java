package cardgame;

import cardgame.factory.PlayerRankerFactory;
import cardgame.model.*;
import cardgame.ranking.PlayerRanker;
import cardgame.ranking.PlayerRankerType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CardTriplePlayerRankerTest {

    PlayerRankerFactory playerRankerFactory = new PlayerRankerFactory();

    @ParameterizedTest
    @MethodSource("playersWithTrails")
    void testWinnerWithTrail(PlayerTestFixture fixture) {
        testAndVerifyWinner(fixture);
    }

    @ParameterizedTest
    @MethodSource("playersWithSequences")
    void testWinnerWithSequence(PlayerTestFixture fixture) {
        testAndVerifyWinner(fixture);
    }

    @ParameterizedTest
    @MethodSource("playersWithPairs")
    void testWinnerWithPair(PlayerTestFixture fixture) {
        testAndVerifyWinner(fixture);
    }

    @ParameterizedTest
    @MethodSource("playersWithNoPatterns")
    void testWinnerWithNoPattern(PlayerTestFixture fixture) {
        testAndVerifyWinner(fixture);
    }

    @ParameterizedTest
    @MethodSource("noWinner")
    void testNoWinner(PlayerTestFixture fixture) {
        testAndVerifyWinner(fixture);
    }

    private void testAndVerifyWinner(PlayerTestFixture fixture) {
        PlayerRanker playerRanker = playerRankerFactory.getPlayerRanker(PlayerRankerType.CARD_TRIPLE, fixture.players);
        playerRanker.rank();
        assertEquals(fixture.expectedWinner, playerRanker.getWinner());
    }

    static Stream<PlayerTestFixture> playersWithTrails() {

        // one trail, three no patterns
        Player player1 = new Player(1, new CardTriple(
                new Card(CardType.FOUR, CardSuit.CLOVES),
                new Card(CardType.FIVE, CardSuit.HEARTS),
                new Card(CardType.NINE, CardSuit.TILES)));

        Player player2 = new Player(2, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player3 = new Player(3, new CardTriple(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.FIVE, CardSuit.TILES)));

        Player player4 = new Player(4, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.TILES)));

        // four trails, highest value wins
        Player player11 = new Player(1, new CardTriple(
                new Card(CardType.FOUR, CardSuit.CLOVES),
                new Card(CardType.FOUR, CardSuit.HEARTS),
                new Card(CardType.FOUR, CardSuit.TILES)));

        Player player21 = new Player(2, new CardTriple(
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.TWO, CardSuit.TILES)));

        Player player31 = new Player(3, new CardTriple(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.THREE, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player41 = new Player(4, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.TILES)));

        // three trails, highest value wins
        Player player12 = new Player(1, new CardTriple(
                new Card(CardType.FOUR, CardSuit.CLOVES),
                new Card(CardType.FIVE, CardSuit.HEARTS),
                new Card(CardType.NINE, CardSuit.TILES)));

        Player player22 = new Player(2, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.TILES)));

        Player player32 = new Player(3, new CardTriple(
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.JACK, CardSuit.HEARTS),
                new Card(CardType.JACK, CardSuit.TILES)));

        Player player42 = new Player(4, new CardTriple(
                new Card(CardType.KING, CardSuit.CLOVES),
                new Card(CardType.KING, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        // one trails, one sequence, one pair, higher score trail wins
        Player player13 = new Player(1, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.FIVE, CardSuit.HEARTS),
                new Card(CardType.FIVE, CardSuit.TILES)));

        Player player23 = new Player(2, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.NINE, CardSuit.TILES)));

        Player player33 = new Player(3, new CardTriple(
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.JACK, CardSuit.HEARTS),
                new Card(CardType.JACK, CardSuit.TILES)));

        Player player43 = new Player(4, new CardTriple(
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        return Stream.of(
                new PlayerTestFixture(Arrays.asList(player1, player2, player3, player4), player4),
                new PlayerTestFixture(Arrays.asList(player11, player21, player31, player41), player11),
                new PlayerTestFixture(Arrays.asList(player12, player22, player32, player42), player42),
                new PlayerTestFixture(Arrays.asList(player13, player23, player33, player43), player33)

        );
    }

    static Stream<PlayerTestFixture> playersWithSequences() {

        // one sequence, three no pattern
        Player player1 = new Player(1, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player2 = new Player(2, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player3 = new Player(3, new CardTriple(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.FIVE, CardSuit.TILES)));

        Player player4 = new Player(4, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.EIGHT, CardSuit.HEARTS),
                new Card(CardType.QUEEN, CardSuit.TILES)));

        // two sequences, one pair, higher value sequence wins
        Player player11 = new Player(1, new CardTriple(
                new Card(CardType.FOUR, CardSuit.CLOVES),
                new Card(CardType.FIVE, CardSuit.HEARTS),
                new Card(CardType.SIX, CardSuit.TILES)));

        Player player21 = new Player(2, new CardTriple(
                new Card(CardType.EIGHT, CardSuit.CLOVES),
                new Card(CardType.NINE, CardSuit.HEARTS),
                new Card(CardType.TEN, CardSuit.TILES)));

        Player player31 = new Player(3, new CardTriple(
                new Card(CardType.KING, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        Player player41 = new Player(4, new CardTriple(
                new Card(CardType.NINE, CardSuit.CLOVES),
                new Card(CardType.EIGHT, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.TILES)));

        // three sequences, highest value wins
        Player player12 = new Player(1, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player22 = new Player(2, new CardTriple(
                new Card(CardType.TEN, CardSuit.CLOVES),
                new Card(CardType.JACK, CardSuit.HEARTS),
                new Card(CardType.QUEEN, CardSuit.TILES)));

        Player player32 = new Player(3, new CardTriple(
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        Player player42 = new Player(4, new CardTriple(
                new Card(CardType.TEN, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        // four sequences, highest value wins
        Player player13 = new Player(1, new CardTriple(
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.THREE, CardSuit.HEARTS),
                new Card(CardType.FOUR, CardSuit.TILES)));

        Player player23 = new Player(2, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.SEVEN, CardSuit.TILES)));

        Player player33 = new Player(3, new CardTriple(
                new Card(CardType.SEVEN, CardSuit.CLOVES),
                new Card(CardType.EIGHT, CardSuit.HEARTS),
                new Card(CardType.NINE, CardSuit.TILES)));

        Player player43 = new Player(4, new CardTriple(
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        return Stream.of(
                new PlayerTestFixture(Arrays.asList(player1, player2, player3, player4), player1),
                new PlayerTestFixture(Arrays.asList(player11, player21, player31, player41), player21),
                new PlayerTestFixture(Arrays.asList(player12, player22, player32, player42), player32),
                new PlayerTestFixture(Arrays.asList(player13, player23, player33, player43), player43)

        );
    }

    static Stream<PlayerTestFixture> playersWithPairs() {

        // one pair, three no pattern
        Player player1 = new Player(1, new CardTriple(
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.TEN, CardSuit.TILES)));

        Player player2 = new Player(2, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player3 = new Player(3, new CardTriple(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.FIVE, CardSuit.TILES)));

        Player player4 = new Player(4, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.EIGHT, CardSuit.HEARTS),
                new Card(CardType.QUEEN, CardSuit.TILES)));

        // two pairs, higher value sequence wins
        Player player11 = new Player(1, new CardTriple(
                new Card(CardType.FOUR, CardSuit.CLOVES),
                new Card(CardType.FOUR, CardSuit.HEARTS),
                new Card(CardType.SIX, CardSuit.TILES)));

        Player player21 = new Player(2, new CardTriple(
                new Card(CardType.EIGHT, CardSuit.CLOVES),
                new Card(CardType.EIGHT, CardSuit.HEARTS),
                new Card(CardType.TEN, CardSuit.TILES)));

        Player player31 = new Player(3, new CardTriple(
                new Card(CardType.KING, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player41 = new Player(4, new CardTriple(
                new Card(CardType.NINE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.TILES)));

        // three pairs, highest value wins
        Player player12 = new Player(1, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player22 = new Player(2, new CardTriple(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.THREE, CardSuit.HEARTS),
                new Card(CardType.QUEEN, CardSuit.TILES)));

        Player player32 = new Player(3, new CardTriple(
                new Card(CardType.QUEEN, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        Player player42 = new Player(4, new CardTriple(
                new Card(CardType.SIX, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        // four pairs, highest value wins
        Player player13 = new Player(1, new CardTriple(
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.FOUR, CardSuit.TILES)));

        Player player23 = new Player(2, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.FIVE, CardSuit.HEARTS),
                new Card(CardType.SEVEN, CardSuit.TILES)));

        Player player33 = new Player(3, new CardTriple(
                new Card(CardType.SEVEN, CardSuit.CLOVES),
                new Card(CardType.SEVEN, CardSuit.HEARTS),
                new Card(CardType.NINE, CardSuit.TILES)));

        Player player43 = new Player(4, new CardTriple(
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.JACK, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        return Stream.of(
                new PlayerTestFixture(Arrays.asList(player1, player2, player3, player4), player1),
                new PlayerTestFixture(Arrays.asList(player11, player21, player31, player41), player21),
                new PlayerTestFixture(Arrays.asList(player12, player22, player32, player42), player32),
                new PlayerTestFixture(Arrays.asList(player13, player23, player33, player43), player43)

        );
    }


    static Stream<PlayerTestFixture> playersWithNoPatterns() {

        // all no pattern
        Player player1 = new Player(1, new CardTriple(
                new Card(CardType.TEN, CardSuit.CLOVES),
                new Card(CardType.QUEEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        Player player2 = new Player(2, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player3 = new Player(3, new CardTriple(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.FIVE, CardSuit.TILES)));

        Player player4 = new Player(4, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.EIGHT, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.TILES)));

        // all no pattern
        Player player11 = new Player(1, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.FOUR, CardSuit.TILES)));

        Player player21 = new Player(2, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.TWO, CardSuit.TILES)));

        Player player31 = new Player(3, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.FOUR, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player41 = new Player(4, new CardTriple(
                new Card(CardType.NINE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        // all no pattern
        Player player12 = new Player(1, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.FOUR, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player22 = new Player(2, new CardTriple(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.QUEEN, CardSuit.TILES)));

        Player player32 = new Player(3, new CardTriple(
                new Card(CardType.TEN, CardSuit.CLOVES),
                new Card(CardType.JACK, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        Player player42 = new Player(4, new CardTriple(
                new Card(CardType.SIX, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        // all no pattern
        Player player13 = new Player(1, new CardTriple(
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.FOUR, CardSuit.TILES)));

        Player player23 = new Player(2, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.SEVEN, CardSuit.TILES)));

        Player player33 = new Player(3, new CardTriple(
                new Card(CardType.SEVEN, CardSuit.CLOVES),
                new Card(CardType.FOUR, CardSuit.HEARTS),
                new Card(CardType.NINE, CardSuit.TILES)));

        Player player43 = new Player(4, new CardTriple(
                new Card(CardType.JACK, CardSuit.CLOVES),
                new Card(CardType.EIGHT, CardSuit.HEARTS),
                new Card(CardType.QUEEN, CardSuit.TILES)));

        return Stream.of(
                new PlayerTestFixture(Arrays.asList(player1, player2, player3, player4), player1),
                new PlayerTestFixture(Arrays.asList(player11, player21, player31, player41), player41),
                new PlayerTestFixture(Arrays.asList(player12, player22, player32, player42), player32),
                new PlayerTestFixture(Arrays.asList(player13, player23, player33, player43), player43)
        );
    }

    static Stream<PlayerTestFixture> noWinner() {

        // two same sequences
        Player player1 = new Player(1, new CardTriple(
                new Card(CardType.ACE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.CLOVES),
                new Card(CardType.THREE, CardSuit.CLOVES)));

        Player player2 = new Player(2, new CardTriple(
                new Card(CardType.ACE, CardSuit.HEARTS),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.THREE, CardSuit.HEARTS)));

        Player player3 = new Player(3, new CardTriple(
                new Card(CardType.THREE, CardSuit.CLOVES),
                new Card(CardType.TWO, CardSuit.HEARTS),
                new Card(CardType.FIVE, CardSuit.TILES)));

        Player player4 = new Player(4, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.EIGHT, CardSuit.HEARTS),
                new Card(CardType.ACE, CardSuit.TILES)));

        // three same sequences
        Player player11 = new Player(1, new CardTriple(
                new Card(CardType.FIVE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.CLOVES),
                new Card(CardType.SEVEN, CardSuit.CLOVES)));

        Player player21 = new Player(2, new CardTriple(
                new Card(CardType.FIVE, CardSuit.HEARTS),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.SEVEN, CardSuit.HEARTS)));

        Player player31 = new Player(3, new CardTriple(
                new Card(CardType.FIVE, CardSuit.TILES),
                new Card(CardType.SIX, CardSuit.TILES),
                new Card(CardType.SEVEN, CardSuit.TILES)));

        Player player41 = new Player(4, new CardTriple(
                new Card(CardType.NINE, CardSuit.CLOVES),
                new Card(CardType.SIX, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        // two same pairs
        Player player12 = new Player(1, new CardTriple(
                new Card(CardType.FOUR, CardSuit.CLOVES),
                new Card(CardType.FOUR, CardSuit.TILES),
                new Card(CardType.THREE, CardSuit.TILES)));

        Player player22 = new Player(2, new CardTriple(
                new Card(CardType.FOUR, CardSuit.HEARTS),
                new Card(CardType.FOUR, CardSuit.PIKES),
                new Card(CardType.THREE, CardSuit.CLOVES)));

        Player player32 = new Player(3, new CardTriple(
                new Card(CardType.TEN, CardSuit.CLOVES),
                new Card(CardType.JACK, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));

        Player player42 = new Player(4, new CardTriple(
                new Card(CardType.SIX, CardSuit.CLOVES),
                new Card(CardType.TEN, CardSuit.HEARTS),
                new Card(CardType.KING, CardSuit.TILES)));


        return Stream.of(
                new PlayerTestFixture(Arrays.asList(player1, player2, player3, player4), null),
                new PlayerTestFixture(Arrays.asList(player11, player21, player31, player41), null),
                new PlayerTestFixture(Arrays.asList(player12, player22, player32, player42), null)
        );
    }

}
