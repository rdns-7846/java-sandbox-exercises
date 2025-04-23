package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ChanceTest {

    @Test
    public void sumChanceExists() {
        List<Integer> roll = List.of(1, 1, 1, 2, 3);
        Die die = new Die(roll);
        int result = Chance.score(die);
        assertThat(result).isEqualTo(8);
    }
}
