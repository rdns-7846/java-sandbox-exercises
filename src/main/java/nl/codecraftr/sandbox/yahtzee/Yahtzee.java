package nl.codecraftr.sandbox.yahtzee;

import java.util.List;

public class Yahtzee {

    public static int score(Die die) {
        var dieRoll = die.getRoll();
        boolean result = dieRoll.stream().distinct().anyMatch(n -> Yahtzee.getNumberCountInList(dieRoll, n) == 5);
        return result ? 50 : 0;
    }

    private static int getNumberCountInList(List<Integer> dieRoll, int number) {
        return dieRoll.stream().filter(n -> n.equals(number)).toList().size();
    }
}
