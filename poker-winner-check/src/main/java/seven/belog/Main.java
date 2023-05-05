package seven.belog;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var hands = List.of(
            new PokerHand("KS 2H 5C JD TD"),
            new PokerHand("TS 2H 5C JD TD")
        );
        System.out.println(hands.stream().max(PokerHand::compareTo).orElseThrow(IllegalAccessError::new));
    }
}