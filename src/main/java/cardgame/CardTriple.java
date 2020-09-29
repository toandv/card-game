package cardgame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardTriple {

    public static final int TRAIL_BASE_SCORE = 10000;

    public static final int SEQUENCE_BASE_SCORE = 1000;

    public static final int PAIR_BASE_SCORE = 100;

    private final Card first;

    private final Card second;

    private final Card third;

    private final int totalScore;

    private boolean isTrail;

    private boolean isSequence;

    private boolean hasPair;

    public CardTriple(Card first, Card second, Card third) {
        this.first = first;
        this.second = second;
        this.third = third;
        recognizePatterns();
        this.totalScore = calculateTotalScore();
    }

    private int calculateTotalScore() {
        int totalScore = first.getScore() + second.getScore() + third.getScore();
        if (this.isTrail) {
            totalScore += TRAIL_BASE_SCORE;
        } else if (this.isSequence) {
            totalScore += SEQUENCE_BASE_SCORE;
        } else if (this.hasPair) {
            totalScore += PAIR_BASE_SCORE;
        }
        return totalScore;
    }

    private void recognizePatterns() {
        if (first.getCardType() == second.getCardType()
                && third.getCardType() == second.getCardType()) {
            this.isTrail = true;
        } else if (first.getCardType() == second.getCardType()
                || third.getCardType() == second.getCardType()
                || first.getCardType() == third.getCardType()) {
            this.hasPair = true;
        } else {
            List<Card> sortedCards = Arrays.asList(first, second, third);
            sortedCards.sort(Comparator.comparingInt(Card::getValue));
            Card card0 = sortedCards.get(0);
            Card card1 = sortedCards.get(1);
            Card card2 = sortedCards.get(2);
            if (card1.getValue() - card0.getValue() == 1 && card2.getValue() - card1.getValue() == 1) {
                this.isSequence = true;
            }
        }
    }

    public boolean isTrail() {
        return isTrail;
    }

    public boolean isSequence() {
        return isSequence;
    }

    public boolean isHasPair() {
        return hasPair;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "CardTriple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", totalScore=" + totalScore +
                ", isTrail=" + isTrail +
                ", isSequence=" + isSequence +
                ", hasPair=" + hasPair +
                '}';
    }
}
