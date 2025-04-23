package nl.codecraftr.sandbox.yahtzee;

public class DoublePair {

    public static int score(Die die) {
        var numbersWithCountTwo = die.getRoll().stream()
                .filter(n -> die.countOf(n) == 2)
                .distinct()
                .toList();
        if (numbersWithCountTwo.size() == 2)
            return 2 * numbersWithCountTwo.stream().mapToInt(n -> n).sum();
        return 0;
    }
}
