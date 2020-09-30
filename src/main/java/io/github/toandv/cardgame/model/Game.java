package io.github.toandv.cardgame.model;

import io.github.toandv.cardgame.exception.MaxPlayersExceededException;
import io.github.toandv.cardgame.factory.CardDeckFactory;
import io.github.toandv.cardgame.factory.PlayerRankerFactory;
import io.github.toandv.cardgame.ranking.PlayerRanker;
import io.github.toandv.cardgame.ranking.PlayerRankerType;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int numberOfCardsDealtToOnePlayer = 3;

    private final List<Player> players;

    private Player winner;

    private CardDeck cardDeck;

    private final int maxPlayers = 17; // 52 / 3

    private final PlayerRankerFactory playerRankerFactory = new PlayerRankerFactory();

    private final CardDeckFactory cardDeckFactory = new CardDeckFactory();

    public Game(int numberOfPlayers) {
        if (numberOfPlayers > this.maxPlayers) {
            throw new MaxPlayersExceededException("Max number of players is " + this.maxPlayers);
        }
        this.players = new ArrayList<>(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i + 1));
        }
        this.cardDeck = cardDeckFactory.createCardDeck(CardDeckType.STANDARD);
    }

    public Game(int numberOfPlayers, CardDeck cardDeck) {
        this(numberOfPlayers);
        this.cardDeck = cardDeck;
    }

    public void play() {
        // shuffle deck
        this.cardDeck.shuffle();

        // deal cards
        dealCardsToPlayers(numberOfCardsDealtToOnePlayer, this.players);
        // tell players to face up cards
        for (Player player : this.players) {
            player.faceUpCards();
        }

        // find winner
        determineWinner();
    }

    public void dealCardsToPlayers(int numberOfCards, List<Player> players) {
        for (int i = 0; i < numberOfCards; i++) {
            for (Player player : players) {
                Card dealtCard = cardDeck.getFirstCard();
                player.receiveCard(dealtCard);
            }
        }
    }

    private void determineWinner() {
        PlayerRanker cardTriplePlayerRanker = playerRankerFactory.getPlayerRanker(PlayerRankerType.CARD_TRIPLE, new ArrayList<>(this.players));
        cardTriplePlayerRanker.rank();
        if (cardTriplePlayerRanker.hasWinner()) {
            this.winner = cardTriplePlayerRanker.getWinner();
        } else {
            determineWinnerFromTiedPlayers(cardTriplePlayerRanker.getTopTiedPlayers());
        }
    }

    public void determineWinnerFromTiedPlayers(List<Player> tiedPlayers) {
        if (this.cardDeck.hasEnoughCards(tiedPlayers.size())) {

            // each tied player draws a random card
            tiedPlayers.forEach(player -> player.drawRandomCard(this.cardDeck));

            PlayerRanker lastDrawnCardPlayerRanker = playerRankerFactory
                    .getPlayerRanker(PlayerRankerType.LAST_DRAWN_CARD, tiedPlayers);
            lastDrawnCardPlayerRanker.rank();

            if (lastDrawnCardPlayerRanker.hasWinner()) {
                this.winner = lastDrawnCardPlayerRanker.getWinner();
            } else {
                determineWinnerFromTiedPlayers(lastDrawnCardPlayerRanker.getTopTiedPlayers());
            }
        }

        // if there are not enough cards for an additional card drawing, then there is no winner
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

}
