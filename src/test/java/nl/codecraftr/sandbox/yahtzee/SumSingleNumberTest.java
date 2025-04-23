package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class SumSingleNumberTest {

    @Test
    public void sumSingleNumberNumberExists() {
        List<Integer> roll = List.of(1, 2, 3, 4, 5, 6);
        Die die = new Die(roll);
        int result = SumSingleNumber.score(die, 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void sumSingleNumberNumberExistsTwo() {
        List<Integer> roll = List.of(1, 2, 3, 4, 5, 6);
        Die die = new Die(roll);
        int result = SumSingleNumber.score(die, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void sumSingleNumberNumberExistsDoubleDieNumber() {
        List<Integer> roll = List.of(2, 2, 3, 4, 5, 6);
        Die die = new Die(roll);
        int result = SumSingleNumber.score(die, 2);
        assertThat(result).isEqualTo(4);
    }
}
