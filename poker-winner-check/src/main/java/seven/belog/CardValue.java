package seven.belog;

public enum CardValue {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

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
