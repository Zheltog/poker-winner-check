package seven.belog;

public record Card(
    CardValue value,
    CardSuit suit
) implements Comparable<Card> {

    public static Card of(String descriptor) {
        if (descriptor.length() != 2) {
            throw new IllegalStateException("Card descriptor should contain 2 symbols describing suit and value");
        }
        return new Card(descriptor.charAt(0), descriptor.charAt(1));
    }

    public Card(char valueDescriptor, char suitDescriptor) {
        this(CardValue.of(valueDescriptor), CardSuit.of(suitDescriptor));
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    @Override
    public int compareTo(Card other) {
        if (this.value == other.value) {
            return 0;
        }

        return this.value.getWeight() > other.value.getWeight() ? 1 : -1;
    }
}