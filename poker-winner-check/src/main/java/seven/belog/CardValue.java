package seven.belog;

public enum CardValue {
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7),
    NINE(8),
    TEN(9),
    JACK(10),
    QUEEN(11),
    KING(12),
    ACE(13);

    private final int weight;

    CardValue(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public static CardValue of(char descriptor) {
        return switch (descriptor) {
            case '2' -> CardValue.TWO;
            case '3' -> CardValue.THREE;
            case '4' -> CardValue.FOUR;
            case '5' -> CardValue.FIVE;
            case '6' -> CardValue.SIX;
            case '7' -> CardValue.SEVEN;
            case '8' -> CardValue.EIGHT;
            case '9' -> CardValue.NINE;
            case 'T' -> CardValue.TEN;
            case 'J' -> CardValue.JACK;
            case 'Q' -> CardValue.QUEEN;
            case 'K' -> CardValue.KING;
            case 'A' -> CardValue.ACE;
            default -> throw new IllegalStateException("Could not define card value for descriptor: " + descriptor);
        };
    }
}
