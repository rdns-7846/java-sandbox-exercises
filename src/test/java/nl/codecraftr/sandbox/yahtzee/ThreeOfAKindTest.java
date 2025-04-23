package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ThreeOfAKindTest {

    @Test
    public void sumSingle3OAKExists() {
        List<Integer> roll = List.of(3, 3, 3, 4, 4);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 3);
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void sumNo3OAKExists() {
        List<Integer> roll = List.of(1, 3, 3, 2, 4);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 3);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void sumDouble3OAKExistsTakeLargest3OAK() {
        List<Integer> roll = List.of(3, 3, 5, 5, 5);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 3);
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void sumSingle4OAKExistsNo3OAKIsTaken() {
        List<Integer> roll = List.of(3, 3, 3, 3, 4);
        Die die = new Die(roll);
        int result = OfAKind.score(die, 3);
        assertThat(result).isEqualTo(0);
    }
}
