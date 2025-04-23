package nl.codecraftr.sandbox.yahtzee;
import java.util.List;

public class Pair {

    public static Integer score(Die die) {
        var dieRoll = die.getRoll();
        var largestPairNumber = dieRoll.stream()
            .filter(n -> Pair.getNumberCountInList(dieRoll,n) == 2 )
            .mapToInt(Integer::intValue)
            .max().orElse(0);
        return largestPairNumber *2;
    }

    private static int getNumberCountInList(List<Integer> dieRoll, int number){
        return dieRoll.stream().filter(n-> n.equals(number)).toList().size();
    }
}
