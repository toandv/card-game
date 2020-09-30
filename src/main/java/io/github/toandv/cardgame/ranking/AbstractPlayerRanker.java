package io.github.toandv.cardgame.ranking;

import io.github.toandv.cardgame.model.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

public abstract class AbstractPlayerRanker implements PlayerRanker {

    protected Player winner;

    protected final List<Player> players;

    protected final List<Player> topTiedPlayers = new ArrayList<>();

    public AbstractPlayerRanker(List<Player> players) {
        this.players = players;
    }

    public boolean hasWinner() {
        return winner != null;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Player> getRankedPlayers() {
        return players;
    }

    public List<Player> getTopTiedPlayers() {
        return topTiedPlayers;
    }

    abstract int getPlayerScore(Player player);

    @Override
    public void rank() {
        // sort players by totalScore, high score first
        players.sort(Comparator.comparingInt(this::getPlayerScore).reversed());

        // find top tied players
        Player firstTopPlayer = players.get(
                0);
        topTiedPlayers.add(firstTopPlayer);
        topTiedPlayers.addAll(players
                .stream()
                .skip(1)
                .filter(player -> getPlayerScore(player) == getPlayerScore(firstTopPlayer))
                .collect(Collectors.toList()));

        // if no other players have the same score as first top player, then the winner is found
        // otherwise, no winner in this ranking
        if (topTiedPlayers.size() == 1) {
            winner = firstTopPlayer;
        }
    }
}
