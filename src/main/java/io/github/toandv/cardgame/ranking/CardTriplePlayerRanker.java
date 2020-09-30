package io.github.toandv.cardgame.ranking;

import io.github.toandv.cardgame.model.Player;

import java.util.List;

public class CardTriplePlayerRanker extends AbstractPlayerRanker {

    public CardTriplePlayerRanker(List<Player> players) {
        super(players);
    }

    @Override
    int getPlayerScore(Player player) {
        return player.getTotalScore();
    }

}
