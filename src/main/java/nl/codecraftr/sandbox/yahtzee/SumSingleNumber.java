package nl.codecraftr.sandbox.yahtzee;

public class SumSingleNumber {

    public static Integer score(Die die, int number) {
        return die.getRoll().stream()
                .filter(n -> n.equals(number))
                .mapToInt(Integer::intValue)
                .sum();
    }
}
