package cardgame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardTriple {

    private Card first;

    private Card second;

    private Card third;

    private int totalScore;

    private boolean isTrail;

    private boolean isSequence;

    private boolean hasPair;

    public CardTriple(Card first, Card second, Card third) {
        this.first = first;
        this.second = second;
        this.third = third;
        recognizePatterns();
        calculateTotalScore();
    }

    private void calculateTotalScore() {
        this.totalScore = first.getScore() + second.getScore() + third.getScore();
    }

    private void recognizePatterns() {
        if (first.getCardType() == second.getCardType()
                && third.getCardType() == second.getCardType()) {
            this.isTrail = true;
        }
        if (first.getCardType() == second.getCardType()
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


    public Card getFirst() {
        return first;
    }

    public Card getSecond() {
        return second;
    }

    public Card getThird() {
        return third;
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
}
