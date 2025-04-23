package nl.codecraftr.sandbox.yahtzee;

public class Straight {

    public static int score(Die die) {
        boolean isDistinct = die.getRoll().stream().distinct().toList().size() == 5;
        int sumOfRoll = die.getRoll().stream().mapToInt(Integer::intValue).sum();

        if (!isDistinct) return 0;
        if ((sumOfRoll == 15) || (sumOfRoll == 20)) return sumOfRoll;
        return 0;
    }
}
