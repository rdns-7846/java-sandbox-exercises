package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PairTest {

    @Test
    public void sumSingleNumberNumberExists() {
        List<Integer> roll = List.of(3, 3, 3, 4, 4, 6);
        Die die = new Die(roll);
        int result = Pair.score(die);
        assertThat(result).isEqualTo(8);
    }
}
