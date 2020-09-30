package cardgame.ranking;

import cardgame.model.Player;

import java.util.List;

public class LastDrawnCardPlayerRanker extends AbstractPlayerRanker {

    public LastDrawnCardPlayerRanker(List<Player> players) {
        super(players);
    }

    @Override
    int getPlayerScore(Player player) {
        return player.getLastDrawnCardOrder();
    }

}
