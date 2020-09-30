package io.github.toandv.cardgame;

import io.github.toandv.cardgame.factory.PlayerRankerFactory;
import cardgame.model.*;
import io.github.toandv.cardgame.model.CardType;
import io.github.toandv.cardgame.ranking.PlayerRanker;
import io.github.toandv.cardgame.ranking.PlayerRankerType;
import io.github.toandv.cardgame.model.Card;
import io.github.toandv.cardgame.model.CardSuit;
import io.github.toandv.cardgame.model.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastDrawnCardPlayerRankerTest {

    PlayerRankerFactory playerRankerFactory = new PlayerRankerFactory();

    @ParameterizedTest
    @MethodSource("playersWithTopOrderCard")
    void testWinner(PlayerTestFixture fixture) {
        testAndVerifyWinner(fixture);
    }

    @ParameterizedTest
    @MethodSource("noWinner")
    void testNoWinner(PlayerTestFixture fixture) {
        testAndVerifyWinner(fixture);
    }

    private void testAndVerifyWinner(PlayerTestFixture fixture) {
        PlayerRanker playerRanker = playerRankerFactory.getPlayerRanker(PlayerRankerType.LAST_DRAWN_CARD, fixture.players);
        playerRanker.rank();
        assertEquals(fixture.expectedWinner, playerRanker.getWinner());
    }

    static Stream<PlayerTestFixture> playersWithTopOrderCard() {

        Player player1 = new Player(1, Arrays.asList(new Card(CardType.FIVE, CardSuit.CLOVES)));
        Player player2 = new Player(1, Arrays.asList(new Card(CardType.TEN, CardSuit.CLOVES)));

        Player player11 = new Player(1, Arrays.asList(new Card(CardType.ACE, CardSuit.CLOVES)));
        Player player21 = new Player(2, Arrays.asList(new Card(CardType.KING, CardSuit.CLOVES)));

        Player player12 = new Player(1, Arrays.asList(new Card(CardType.TEN, CardSuit.CLOVES)));
        Player player22 = new Player(2, Arrays.asList(new Card(CardType.QUEEN, CardSuit.CLOVES)));
        Player player32 = new Player(3, Arrays.asList(new Card(CardType.JACK, CardSuit.CLOVES)));

        Player player13 = new Player(1, Arrays.asList(new Card(CardType.ACE, CardSuit.CLOVES)));
        Player player23 = new Player(2, Arrays.asList(new Card(CardType.QUEEN, CardSuit.CLOVES)));
        Player player33 = new Player(3, Arrays.asList(new Card(CardType.KING, CardSuit.CLOVES)));

        return Stream.of(
                new PlayerTestFixture(Arrays.asList(player1, player2), player2),
                new PlayerTestFixture(Arrays.asList(player11, player21), player11),
                new PlayerTestFixture(Arrays.asList(player12, player22, player32), player22),
                new PlayerTestFixture(Arrays.asList(player13, player23, player33), player13)
        );
    }

    static Stream<PlayerTestFixture> noWinner() {

        Player player1 = new Player(1, Arrays.asList(new Card(CardType.FIVE, CardSuit.CLOVES)));
        Player player2 = new Player(1, Arrays.asList(new Card(CardType.FIVE, CardSuit.TILES)));

        Player player11 = new Player(1, Arrays.asList(new Card(CardType.KING, CardSuit.PIKES)));
        Player player21 = new Player(2, Arrays.asList(new Card(CardType.KING, CardSuit.CLOVES)));

        Player player12 = new Player(1, Arrays.asList(new Card(CardType.TEN, CardSuit.CLOVES)));
        Player player22 = new Player(2, Arrays.asList(new Card(CardType.TEN, CardSuit.PIKES)));
        Player player32 = new Player(3, Arrays.asList(new Card(CardType.TEN, CardSuit.HEARTS)));

        Player player13 = new Player(1, Arrays.asList(new Card(CardType.QUEEN, CardSuit.CLOVES)));
        Player player23 = new Player(2, Arrays.asList(new Card(CardType.QUEEN, CardSuit.PIKES)));
        Player player33 = new Player(3, Arrays.asList(new Card(CardType.QUEEN, CardSuit.HEARTS)));

        return Stream.of(
                new PlayerTestFixture(Arrays.asList(player1, player2), null),
                new PlayerTestFixture(Arrays.asList(player11, player21), null),
                new PlayerTestFixture(Arrays.asList(player12, player22, player32), null),
                new PlayerTestFixture(Arrays.asList(player13, player23, player33), null)
        );
    }

}
