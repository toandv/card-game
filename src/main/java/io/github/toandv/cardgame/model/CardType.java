package io.github.toandv.cardgame.model;

public enum CardType {

    ACE("A", 1, 14),

    KING("K", 13, 13),

    QUEEN("Q", 12, 12),

    JACK("J", 11, 11),

    TEN("10", 10, 10),

    NINE("9", 9, 9),

    EIGHT("8", 8, 8),

    SEVEN("7", 7, 7),

    SIX("6", 6, 6),

    FIVE("5", 5, 5),

    FOUR("4", 4, 4),

    THREE("3", 3, 3),

    TWO("2", 2, 2);

    private final int value;

    private final int topCardOrder;

    private final String shortName;

    CardType(String shortName, int value, int topCardOrder) {
        this.shortName = shortName;
        this.value = value;
        this.topCardOrder = topCardOrder;
    }

    public int getValue() {
        return value;
    }

    public int getTopCardOrder() {
        return topCardOrder;
    }

    public String getShortName() {
        return shortName;
    }
}
