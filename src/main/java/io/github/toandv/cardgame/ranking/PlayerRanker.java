package io.github.toandv.cardgame.ranking;

import io.github.toandv.cardgame.model.Player;

import java.util.List;

public interface PlayerRanker {

    void rank();

    boolean hasWinner();

    Player getWinner();

    List<Player> getRankedPlayers();

    List<Player> getTopTiedPlayers();

}
