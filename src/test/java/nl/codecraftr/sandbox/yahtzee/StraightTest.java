package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class StraightTest {

    @Test
    public void NoStraightFound() {
        List<Integer> roll = List.of(1, 1, 1, 2, 3);
        Die die = new Die(roll);
        int result = Straight.score(die);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void SmallStraightFound() {
        List<Integer> roll = List.of(1, 2, 3, 4, 5);
        Die die = new Die(roll);
        int result = Straight.score(die);
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void LargeStraightFound() {
        List<Integer> roll = List.of(2, 3, 4, 5, 6);
        Die die = new Die(roll);
        int result = Straight.score(die);
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void DistinctThrowFoundButNoStraight() {
        List<Integer> roll = List.of(1, 3, 4, 5, 6);
        Die die = new Die(roll);
        int result = Straight.score(die);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void ThrowSumsToFifteenNoStraightFound() {
        List<Integer> roll = List.of(1, 4, 4, 1, 5);
        Die die = new Die(roll);
        int result = Straight.score(die);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void ThrowSumsToTwentyNoStraightFound() {
        List<Integer> roll = List.of(2, 5, 2, 5, 6);
        Die die = new Die(roll);
        int result = Straight.score(die);
        assertThat(result).isEqualTo(0);
    }
}
