package cardgame;

public enum CardType {

    ACE(1, 14),

    KING(13, 13),

    QUEEN(12, 12),

    JACK(11, 12),

    TEN(10, 10),

    NINE(9, 9),

    EIGHT(8, 8),

    SEVEN(7, 7),

    SIX(6, 6),

    FIVE(5, 5),

    FOUR(4, 4),

    THREE(3, 3),

    TWO(2, 2);

    private int value;

    private int score;

    CardType(int value, int score) {
        this.value = value;
        this.score = score;
    }

    public int getValue() {
        return value;
    }

    public int getScore() {
        return score;
    }
}
