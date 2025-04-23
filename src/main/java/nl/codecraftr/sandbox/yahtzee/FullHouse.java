package nl.codecraftr.sandbox.yahtzee;

public class FullHouse {
    public static int score(Die die) {
        return OfAKind.score(die, 2) + OfAKind.score(die, 3);
    }
}
