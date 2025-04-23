package nl.codecraftr.sandbox.yahtzee;

public class Yahtzee {

    public static int score(Die die) {
        var dieRoll = die.getRoll();
        boolean result = dieRoll.stream().distinct().anyMatch(n -> die.countOf(n) == 5);
        return result ? 50 : 0;
    }
}
