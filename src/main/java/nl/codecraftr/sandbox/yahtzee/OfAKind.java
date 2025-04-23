package nl.codecraftr.sandbox.yahtzee;

public class OfAKind {

    public static Integer score(Die die, int ofAKind) {
        var dieRoll = die.getRoll();
        var largestPairNumber = dieRoll.stream()
                .filter(n -> die.countOf(n) == ofAKind)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        return largestPairNumber * ofAKind;
    }
}
