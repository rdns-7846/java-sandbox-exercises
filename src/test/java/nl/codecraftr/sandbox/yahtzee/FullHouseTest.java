package nl.codecraftr.sandbox.yahtzee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class FullHouseTest {

    @Test
    public void Single4OAKExistsNoFullHouseScoreEqualsZero() {
        List<Integer> roll = List.of(3, 3, 3, 3, 4);
        Die die = new Die(roll);
        int result = FullHouse.score(die);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void YahtzeeExistsNoFullHouseScoreEqualsZero() {
        List<Integer> roll = List.of(3, 3, 3, 3, 3);
        Die die = new Die(roll);
        int result = FullHouse.score(die);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void FullHouseExistsScoreEqualsFullHouseScore() {
        List<Integer> roll = List.of(1, 1, 2, 2, 2);
        Die die = new Die(roll);
        int result = FullHouse.score(die);
        assertThat(result).isEqualTo(8);
    }
}
