package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int numberOfCardsDealtToOnePlayer = 3;

    private final List<Player> players;

    private Player winner;

    private final Deck deck;

    private int maxPlayers = 17; // 52 / 3

    public Game(int numberOfPlayers) {
        if (numberOfPlayers > this.maxPlayers) {
            throw new MaxPlayersExceededException("Max number of players is " + this.maxPlayers);
        }
        this.players = new ArrayList<>(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i + 1));
        }
        this.deck = DeckFactory.createDeck();
    }

    public void play() {
        // shuffle deck
        this.deck.shuffle();

        // deal cards
        dealCardsToPlayers(numberOfCardsDealtToOnePlayer, this.players);
        // tell players to face up cards
        for (Player player : this.players) {
            player.faceUpCards();
        }

        // find winner
        determineWinner(this.players);
    }

    private void dealCardsToPlayers(int numberOfCards, List<Player> players) {
        for (int i = 0; i < numberOfCards; i++) {
            for (Player player : players) {
                Card dealtCard = deck.takeCard();
                player.receiveCard(dealtCard);
            }
        }
    }

    private void determineWinner(List<Player> players) {
        PlayerRanker playerRanker = new PlayerRanker(players);
        playerRanker.rank();
        if (playerRanker.hasWinner()) {
            this.winner = playerRanker.getWinner();
        } else {
            List<Player> tiedPlayers = playerRanker.getTopTiedPlayers();
            if (this.deck.hasCardsToDeal(tiedPlayers.size())) {
                this.deck.shuffle();
                dealCardsToPlayers(1, tiedPlayers);
                determineWinner(tiedPlayers);
            }
        }
    }

    public Player getWinner() {
        return winner;
    }

}
