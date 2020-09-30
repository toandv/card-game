package io.github.toandv.cardgame;

import io.github.toandv.cardgame.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerTestFixture {

    public final List<Player> players;

    public final Player expectedWinner;

    public PlayerTestFixture(List<Player> players, Player expectedWinner) {
        this.players = new ArrayList<>(players);
        this.expectedWinner = expectedWinner;
    }

}