package cardgame.factory;

import cardgame.model.Player;
import cardgame.ranking.CardTriplePlayerRanker;
import cardgame.ranking.LastDrawnCardPlayerRanker;
import cardgame.ranking.PlayerRanker;
import cardgame.ranking.PlayerRankerType;

import java.util.List;
import java.util.Objects;

public class PlayerRankerFactory {

    public PlayerRanker getPlayerRanker(PlayerRankerType type, List<Player> players) {
        Objects.requireNonNull(type, "type must not be null!");
        Objects.requireNonNull(players, "players must not be null!");
        switch (type) {
            case CARD_TRIPLE:
                return new CardTriplePlayerRanker(players);
            case LAST_DRAWN_CARD:
                return new LastDrawnCardPlayerRanker(players);
        }
        throw new RuntimeException("Never get here!");
    }

}
