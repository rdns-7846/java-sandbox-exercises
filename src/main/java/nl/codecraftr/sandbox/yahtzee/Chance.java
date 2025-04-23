package nl.codecraftr.sandbox.yahtzee;

public class Chance {

    public static int score(Die die) {
        return die.getRoll().stream().mapToInt(Integer::intValue).sum();
    }
}
