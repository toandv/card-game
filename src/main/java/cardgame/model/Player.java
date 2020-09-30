package cardgame.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Player {

    private int playerId;

    private CardTriple cardTriple;

    private List<Card> dealtCards = new ArrayList<>();

    private LinkedList<Card> drawnCards = new LinkedList<>();

    public Player(int playerId) {
        this.playerId = playerId;
    }

    public Player(int playerId, CardTriple cardTriple) {
        this.playerId = playerId;
        this.cardTriple = cardTriple;
    }

    public Player(int playerId, List<Card> drawnCards) {
        this.playerId = playerId;
        this.drawnCards.addAll(drawnCards);
    }

    public void receiveCard(Card card) {
        dealtCards.add(card);
    }

    public void drawRandomCard(CardDeck deck) {
        Card card = deck.getRandomCard();
        drawnCards.addLast(card);
    }

    public void faceUpCards() {
        this.cardTriple = new CardTriple(dealtCards.get(0), dealtCards.get(1), dealtCards.get(2));
    }

    public int getTotalScore() {
        return cardTriple.getTotalScore();
    }

    public int getLastDrawnCardOrder() {
        if (drawnCards.isEmpty()) {
            return 0;
        }
        return drawnCards.getLast().getTopCardOrder();
    }

    public int getPlayerId() {
        return playerId;
    }

    public CardTriple getCardTriple() {
        return cardTriple;
    }

    public List<Card> getDealtCards() {
        return dealtCards;
    }

    public LinkedList<Card> getDrawnCards() {
        return drawnCards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", cardTriple=" + cardTriple +
                ", drawnCards=" + drawnCards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }
}
