package cardgame;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayerRanker {

    private Player winner;

    private List<Player> players;

    private List<Player> topTiedPlayers = new ArrayList<>();

    public PlayerRanker(List<Player> players) {
        this.players = players;
    }

    public void rank() {
        // top players first
        players.sort(Comparator.comparingInt(Player::getTotalScore)
                .thenComparingInt(Player::getAdditionalCardScore)
                .reversed());
        Player firstTopPlayer = players.get(0);
        topTiedPlayers.add(firstTopPlayer);
        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            if (firstTopPlayer.getTotalScore() == player.getTotalScore()) {
                topTiedPlayers.add(player);
            }
        }
        if (topTiedPlayers.size() == 1) {
            winner = firstTopPlayer;
        }
    }

    public boolean hasWinner() {
        return winner != null;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> getTopTiedPlayers() {
        return topTiedPlayers;
    }
}
