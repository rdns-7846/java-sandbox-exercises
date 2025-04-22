package nl.codecraftr.sandbox.yahtzee;

public class Pair {

    public static Integer score(Die die) {
        return die.getRoll().stream()
//            .filter(n -> n.equals(number))
            .mapToInt(Integer::intValue)
            .sum();
    }
}
