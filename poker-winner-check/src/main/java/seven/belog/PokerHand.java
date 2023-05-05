package seven.belog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand implements Comparable<PokerHand> {

    List<Card> cards;
    Card hidhCard;
    Combination combination;

    public PokerHand(String descriptor) {
        var parsedCards = parseCards(descriptor);
        if (parsedCards.size() != 5) {
            throw new IllegalStateException("Poker hand should contain 5 cards exactly");
        }
        this.cards = parsedCards;
        this.hidhCard = this.cards.stream().max(Card::compareTo).orElseThrow(IllegalStateException::new);
        this.combination = Combination.of(this.cards);
    }

    private List<Card> parseCards(String descriptor) {
        return Arrays
                .stream(descriptor.split(" "))
                .map(Card::of)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Poker hand: cards = " + cards.toString() + ", high card = " + hidhCard + ", combination = " + combination;
    }

    @Override
    public int compareTo(PokerHand other) {
        var combosComparison = Integer.compare(this.combination.getWeight(), other.combination.getWeight());
        if (combosComparison == 0) {
            return this.hidhCard.compareTo(other.hidhCard);
        } else {
            return combosComparison;
        }
    }
}
