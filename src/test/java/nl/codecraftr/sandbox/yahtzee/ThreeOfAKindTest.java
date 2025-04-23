package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.List;

public class ThreeOfAKindTest {

    @Test
    public void sumSingle3OAKExists() {
        List<Integer> roll = List.of(3, 3, 3, 4, 4, 6);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 3);
        assertThat(result).isEqualTo(9);
    }
    @Test
    public void sumNo3OAKExists() {
        List<Integer> roll = List.of(1, 3, 3, 2, 4, 6);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 3);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void sumDoublePairExistsTakeLargestPair() {
        List<Integer> roll = List.of(3, 3, 3, 5, 5, 5);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 3);
        assertThat(result).isEqualTo(15);
    }
}
