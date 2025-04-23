package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class YahtzeeTest {

    @Test
    public void sumYahtzeeMatchesToYahtzee() {
        List<Integer> roll = List.of(5, 5, 5, 5, 5);
        Die die = new Die(roll);
        int result = Yahtzee.score(die);
        assertThat(result).isEqualTo(50);
    }

    @Test
    public void sumNoYahtzeeMatchesToZero() {
        List<Integer> roll = List.of(1, 2, 3, 4, 5);
        Die die = new Die(roll);
        int result = Yahtzee.score(die);
        assertThat(result).isEqualTo(0);
    }
}
