package nl.codecraftr.sandbox.yahtzee;

import java.util.List;

public class OfAKind {

    public static Integer score(Die die, int ofAKind) {
        var dieRoll = die.getRoll();
        var largestPairNumber = dieRoll.stream()
                .filter(n -> OfAKind.getNumberCountInList(dieRoll, n) == ofAKind)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        return largestPairNumber * ofAKind;
    }

    private static int getNumberCountInList(List<Integer> dieRoll, int number) {
        return dieRoll.stream().filter(n -> n.equals(number)).toList().size();
    }
}
