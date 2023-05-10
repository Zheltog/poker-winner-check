package seven.belog;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CombinationTest {

    @Test
    void defineCombination() {
        // JD TD KD QD AD -> ROYAL FLUSH
        assertThat(Combination.of(List.of(
            Card.of("JD"),
            Card.of("TD"),
            Card.of("KD"),
            Card.of("QD"),
            Card.of("AD")
        ))).isEqualTo(Combination.ROYAL_FLUSH);

        // 4C 5C 3C 7C 6C -> STRAIGHT FLUSH
        assertThat(Combination.of(List.of(
            Card.of("4C"),
            Card.of("5C"),
            Card.of("3C"),
            Card.of("7C"),
            Card.of("6C")
        ))).isEqualTo(Combination.STRAIGHT_FLUSH);

        // 4S 4H 4C 4D KS -> FOUR OF A KING
        assertThat(Combination.of(List.of(
            Card.of("4S"),
            Card.of("4H"),
            Card.of("4C"),
            Card.of("4D"),
            Card.of("KS")
        ))).isEqualTo(Combination.FOUR_OF_A_KING);

        // TH TC TD 2S 2D -> FULL HOUSE
        assertThat(Combination.of(List.of(
            Card.of("TH"),
            Card.of("TC"),
            Card.of("TD"),
            Card.of("2S"),
            Card.of("2D")
        ))).isEqualTo(Combination.FULL_HOUSE);

        // KS 9S JS 5S AS -> FLUSH
        assertThat(Combination.of(List.of(
            Card.of("KS"),
            Card.of("9S"),
            Card.of("JS"),
            Card.of("5S"),
            Card.of("AS")
        ))).isEqualTo(Combination.FLUSH);

        // 9C 7S 8D JD TH -> STRAIGHT
        assertThat(Combination.of(List.of(
            Card.of("9C"),
            Card.of("7S"),
            Card.of("8D"),
            Card.of("JD"),
            Card.of("TH")
        ))).isEqualTo(Combination.STRAIGHT);

        // 2H 2C 2D 6S AH -> THREE OF A KING
        assertThat(Combination.of(List.of(
            Card.of("2H"),
            Card.of("2C"),
            Card.of("2D"),
            Card.of("6S"),
            Card.of("AH")
        ))).isEqualTo(Combination.THREE_OF_A_KING);

        // 8C 8D 7H 7C QC -> TWO PAIR
        assertThat(Combination.of(List.of(
            Card.of("8C"),
            Card.of("8D"),
            Card.of("7H"),
            Card.of("7C"),
            Card.of("QC")
        ))).isEqualTo(Combination.TWO_PAIR);

        // 5S 5D JC TH 3C -> ONE PAIR
        assertThat(Combination.of(List.of(
            Card.of("5S"),
            Card.of("5D"),
            Card.of("JC"),
            Card.of("TH"),
            Card.of("3C")
        ))).isEqualTo(Combination.ONE_PAIR);

        // KH 2S 8C JD 6D -> HIGH CARD
        assertThat(Combination.of(List.of(
            Card.of("KH"),
            Card.of("2S"),
            Card.of("8C"),
            Card.of("JD"),
            Card.of("6D")
        ))).isEqualTo(Combination.HIGH_CARD);
    }
}