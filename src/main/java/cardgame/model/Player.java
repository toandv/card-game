package cardgame.model;

import cardgame.model.Card;
import cardgame.model.CardDeck;
import cardgame.model.CardTriple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {

    private int playerId;

    private CardTriple cardTriple;

    private List<Card> dealtCards = new ArrayList<>();

    private LinkedList<Card> drawnCards = new LinkedList<>();

    public Player(int playerId) {
        this.playerId = playerId;
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

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", cardTriple=" + cardTriple +
                ", dealtCards=" + dealtCards +
                '}';
    }
}
