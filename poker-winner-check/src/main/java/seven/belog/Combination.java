package seven.belog;

import java.util.List;

public enum Combination {
    ROYAL_FLUSH,
    STRAIGHT_FLUSH,
    FOUR_OF_A_KING,
    FULL_HOUSE,
    FLUSH,
    STRAIGHT,
    THREE_OF_A_KING,
    TWO_PAIR,
    ONE_PAIR,
    HIGH_CARD;

    public static Combination of(List<Card> cards) {
        return HIGH_CARD;
    }
}