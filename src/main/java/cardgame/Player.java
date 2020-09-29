package cardgame;

import java.util.LinkedList;

public class Player {

    private int playerId;

    private CardTriple cardTriple;

    private LinkedList<Card> dealtCards = new LinkedList<>();

    public Player(int playerId) {
        this.playerId = playerId;
    }

    public void receiveCard(Card card) {
        dealtCards.addLast(card);
    }

    public void faceUpCards() {
        this.cardTriple = new CardTriple(dealtCards.get(0), dealtCards.get(1), dealtCards.get(2));
    }

    public int getTotalScore() {
        return cardTriple.getTotalScore();
    }

    public int getAdditionalCardScore() {
        if (dealtCards.size() == 3) {
            return 0;
        }
        return dealtCards.getLast().getScore();
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
