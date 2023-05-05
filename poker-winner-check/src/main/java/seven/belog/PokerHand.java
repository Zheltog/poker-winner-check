package seven.belog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand {

    List<Card> cards;
    Combination combination;

    public PokerHand(String descriptor) {
        var parsedCards = parseCards(descriptor);
        if (parsedCards.size() != 5) {
            throw new IllegalStateException("Poker hand should contain 5 cards exactly");
        }
        this.cards = parsedCards;
        this.combination = Combination.of(this.cards);
    }

    @Override
    public String toString() {
        return "Poker hand: cards = " + cards.toString() + ", combination = " + combination;
    }

    private List<Card> parseCards(String descriptor) {
        return Arrays
                .stream(descriptor.split(" "))
                .map(Card::of)
                .collect(Collectors.toList());
    }
}
