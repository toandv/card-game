package io.github.toandv.cardgame.model;

public enum CardTriplePattern {

    TRAIL(10000),

    SEQUENCE(1000),

    PAIR(100),

    NO_PATTERN(0);

    private final int score;

    CardTriplePattern(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
