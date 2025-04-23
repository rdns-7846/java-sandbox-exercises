package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PairTest {

    @Test
    public void sumSinglePairExists() {
        List<Integer> roll = List.of(3, 3, 3, 4, 4, 6);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 2);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void sumNoPairExists() {
        List<Integer> roll = List.of(1, 3, 3, 2, 4, 6);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 2);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void sumDoublePairExistsTakeLargestPair() {
        List<Integer> roll = List.of(3, 3, 2, 5, 5, 6);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 2);
        assertThat(result).isEqualTo(10);
    }
}
