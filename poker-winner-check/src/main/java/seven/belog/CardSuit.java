package seven.belog;

public enum CardSuit {
    SPADES,
    HEARTS,
    DIAMONDS,
    CLUBS;

    public static CardSuit of(char descriptor) {
        return switch (descriptor) {
            case 'S' -> CardSuit.SPADES;
            case 'H' -> CardSuit.HEARTS;
            case 'D' -> CardSuit.DIAMONDS;
            case 'C' -> CardSuit.CLUBS;
            default -> throw new IllegalStateException("Could not define card suit for descriptor: " + descriptor);
        };
    }
}