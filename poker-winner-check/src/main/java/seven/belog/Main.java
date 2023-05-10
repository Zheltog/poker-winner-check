package seven.belog;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        System.out.println(hands.stream().max(PokerHand::compareTo).orElseThrow(IllegalStateException::new));
    }
}