package seven.belog;

import java.util.*;

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
        SortedMap<CardValue, Integer> valuesToCounts = valuesToCounts(cards);
        Map<CardSuit, Integer> suitsToCounts = suitsToCounts(cards);

        StraightType straightType = straightTypeOf(valuesToCounts, cards.size());
        boolean oneSuit = suitsToCounts.keySet().size() == 1;

        int pairsCount = 0;
        int threesCount = 0;
        int foursCount = 0;

        for (var entry: valuesToCounts.entrySet()) {
            var size = entry.getValue();
            if (size == 2) {
                pairsCount++;
            } else if (size == 3) {
                threesCount++;
            } else if (size == 4) {
                foursCount++;
            }
        }

        return calculateCombo(straightType, oneSuit, pairsCount, threesCount, foursCount);
    }

    private static Combination calculateCombo(
        StraightType straightType,
        boolean oneSuit,
        int pairsCount,
        int threesCount,
        int foursCount
    ) {
        if (oneSuit && straightType == StraightType.TO_HIGHEST) {
            return ROYAL_FLUSH;
        }

        if (oneSuit && straightType == StraightType.SIMPLE) {
            return STRAIGHT_FLUSH;
        }

        if (foursCount == 1) {
            return FOUR_OF_A_KING;
        }

        if (threesCount == 1 && pairsCount == 1) {
            return FULL_HOUSE;
        }

        if (oneSuit) {
            return FLUSH;
        }

        if (straightType != StraightType.NONE) {
            return STRAIGHT;
        }

        if (threesCount == 1) {
            return THREE_OF_A_KING;
        }

        if (pairsCount == 2) {
            return TWO_PAIR;
        }

        if (pairsCount == 1) {
            return ONE_PAIR;
        }

        return HIGH_CARD;
    }

    private static StraightType straightTypeOf(SortedMap<CardValue, Integer> valuesToCounts, int comboSize) {
        List<CardValue> values = valuesToCounts.keySet().stream().toList();

        if (values.size() != comboSize) {
            return StraightType.NONE;
        }

        int weightsRange = values.get(comboSize - 1).getWeight() - values.get(0).getWeight();

        if (weightsRange > 4) {
            return StraightType.NONE;
        }

        if (values.get(comboSize - 1) == CardValue.ACE) {
            return StraightType.TO_HIGHEST;
        }

        return StraightType.SIMPLE;
    }

    private enum StraightType {
        NONE,
        SIMPLE,
        TO_HIGHEST
    }

    private static SortedMap<CardValue, Integer> valuesToCounts(List<Card> cards) {
        SortedMap<CardValue, Integer> valuesToCounts = new TreeMap<>();
        for (var card: cards) {
            var value = card.value();
            var currentCount = valuesToCounts.get(value);
            valuesToCounts.put(value, currentCount == null ? 1 : currentCount + 1);
        }
        return valuesToCounts;
    }

    private static Map<CardSuit, Integer> suitsToCounts(List<Card> cards) {
        Map<CardSuit, Integer> suitsToCounts = new HashMap<>();
        for (var card: cards) {
            var suit = card.suit();
            var currentCount = suitsToCounts.get(suit);
            suitsToCounts.put(suit, currentCount == null ? 0 : currentCount + 1);
        }
        return suitsToCounts;
    }
}