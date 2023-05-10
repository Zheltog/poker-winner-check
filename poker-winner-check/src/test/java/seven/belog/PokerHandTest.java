package seven.belog;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PokerHandTest {

    @Test
    void compareHands() {
        var hands = List.of(
            new PokerHand("KH 2S 8C JD 6D"),
            new PokerHand("5S 5D JC TH 3C"),
            new PokerHand("8C 8D 7H 7C QC"),
            new PokerHand("2H 2C 2D 6S AH"),
            new PokerHand("9C 7S 8D JD TH"),
            new PokerHand("KS 9S JS 5S AS"),
            new PokerHand("TH TC TD 2S 2D"),
            new PokerHand("4S 4H 4C 4D KS"),
            new PokerHand("4C 5C 3C 7C 6C"),
            new PokerHand("JD TD KD QD AD")
        );

        var bestHand = hands.stream().max(PokerHand::compareTo).orElseThrow(IllegalStateException::new);

        assertThat(bestHand.combination).isEqualTo(Combination.ROYAL_FLUSH);
        assertThat(bestHand.hidhCard).isEqualTo(Card.of("AD"));
    }

    @Test
    void defineCombinations() {
        assertThat(new PokerHand("JD TD KD QD AD").combination)
            .isEqualTo(Combination.ROYAL_FLUSH);

        assertThat(new PokerHand("4C 5C 3C 7C 6C").combination)
            .isEqualTo(Combination.STRAIGHT_FLUSH);

        assertThat(new PokerHand("4S 4H 4C 4D KS").combination)
            .isEqualTo(Combination.FOUR_OF_A_KING);

        assertThat(new PokerHand("TH TC TD 2S 2D").combination)
            .isEqualTo(Combination.FULL_HOUSE);

        assertThat(new PokerHand("KS 9S JS 5S AS").combination)
            .isEqualTo(Combination.FLUSH);

        assertThat(new PokerHand("9C 7S 8D JD TH").combination)
            .isEqualTo(Combination.STRAIGHT);

        assertThat(new PokerHand("2H 2C 2D 6S AH").combination)
            .isEqualTo(Combination.THREE_OF_A_KING);

        assertThat(new PokerHand("8C 8D 7H 7C QC").combination)
            .isEqualTo(Combination.TWO_PAIR);

        assertThat(new PokerHand("5S 5D JC TH 3C").combination)
            .isEqualTo(Combination.ONE_PAIR);

        assertThat(new PokerHand("KH 2S 8C JD 6D").combination)
            .isEqualTo(Combination.HIGH_CARD);
    }
}