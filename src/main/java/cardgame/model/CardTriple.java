package cardgame.model;

import cardgame.model.Card;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CardTriple {

    private final Card first;

    private final Card second;

    private final Card third;

    private final CardTriplePattern pattern;

    private final int totalScore;

    public CardTriple(Card first, Card second, Card third) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.pattern = recognizePatterns();
        this.totalScore = calculateTotalScore();
    }

    private int calculateTotalScore() {
        return pattern.getScore() + first.getValue() + second.getValue() + third.getValue();
    }

    private CardTriplePattern recognizePatterns() {
        if (first.getCardType() == second.getCardType()
                && third.getCardType() == second.getCardType()) {
            return CardTriplePattern.TRAIL;
        } else if (first.getCardType() == second.getCardType()
                || third.getCardType() == second.getCardType()
                || first.getCardType() == third.getCardType()) {
            return CardTriplePattern.PAIR;
        } else {
            List<Card> sortedCards = Arrays.asList(first, second, third);
            sortedCards.sort(Comparator.comparingInt(Card::getValue));
            Card card0 = sortedCards.get(0);
            Card card1 = sortedCards.get(1);
            Card card2 = sortedCards.get(2);
            if (card1.getValue() - card0.getValue() == 1 && card2.getValue() - card1.getValue() == 1) {
                return CardTriplePattern.SEQUENCE;
            }
        }
        return CardTriplePattern.NO_PATTERN;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public CardTriplePattern getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "CardTriple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", pattern=" + pattern +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardTriple that = (CardTriple) o;
        return first.equals(that.first) &&
                second.equals(that.second) &&
                third.equals(that.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
