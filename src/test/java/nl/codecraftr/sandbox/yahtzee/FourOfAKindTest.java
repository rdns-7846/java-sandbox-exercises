package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class FourOfAKindTest {

    @Test
    public void sumSingle4OAKExists() {
        List<Integer> roll = List.of(3, 3, 3, 3, 4, 6);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 4);
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void sumNo4OAKExists() {
        List<Integer> roll = List.of(1, 3, 3, 2, 4, 6);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 4);
        assertThat(result).isEqualTo(0);
    }
}
