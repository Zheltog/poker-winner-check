package seven.belog;

public record Card(
    CardSuit suit,
    CardValue value
) {

    public Card(char suitDescriptor, char valueDescriptor) {
        this(CardSuit.of(suitDescriptor), CardValue.of(valueDescriptor));
    }
}