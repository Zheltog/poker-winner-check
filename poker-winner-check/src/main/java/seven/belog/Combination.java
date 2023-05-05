package seven.belog;

import java.util.List;

public enum Combination {
    ROYAL_FLUSH(10),
    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KING(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KING(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARD(1);

    private final int weight;

    Combination(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public static Combination of(List<Card> cards) {
        return HIGH_CARD;
    }
}