package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class DieTest {

    @Test
    public void testContentDie() {
        List<Integer> roll = List.of(1, 2, 3, 4, 5);
        Die die = new Die(roll);
        assertThat(die.getRoll()).isEqualTo(roll);
        assertThat(die.getRoll().size()).isEqualTo(5);
    }
}
