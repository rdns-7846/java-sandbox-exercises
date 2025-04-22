package nl.codecraftr.sandbox.tennis;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ScoreProcessorTest {

    @Test
    public void LoveLovePlayerOneWins() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        assertThat(match.getScore()).isEqualTo(List.of(Point.FIFTEEN, Point.LOVE));
        assertThat(match.hasEnded()).isEqualTo(false);
    }

    @Test
    public void PlayerOneToForty() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        assertThat(match.getScore()).isEqualTo(List.of(Point.FORTY, Point.LOVE));
        assertThat(match.hasEnded()).isEqualTo(false);
    }

    @Test
    public void PlayerOneToWin() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        assertThat(match.getScore()).isEqualTo(List.of(Point.WIN, Point.LOVE));
        assertThat(match.hasEnded()).isEqualTo(true);
        assertThat(match.getWinner()).isEqualTo(p1);
    }

    @Test
    public void PlayerDeuces() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");

        assertThat(match.getScore()).isEqualTo(List.of(Point.DEUCE, Point.DEUCE));
        assertThat(match.hasEnded()).isEqualTo(false);
    }

    @Test
    public void PlayerDeuceToAdvantage() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p1");

        assertThat(match.getScore()).isEqualTo(List.of(Point.ADVANTAGE, Point.FORTY));
        assertThat(match.hasEnded()).isEqualTo(false);
    }

    @Test
    public void PlayerAdvantageToDeuce() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p2");

        assertThat(match.getScore()).isEqualTo(List.of(Point.DEUCE, Point.DEUCE));
        assertThat(match.hasEnded()).isEqualTo(false);
    }

    @Test
    public void PlayerDeuceToForty() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");

        assertThat(match.getScore()).isEqualTo(List.of(Point.FORTY, Point.ADVANTAGE));
        assertThat(match.hasEnded()).isEqualTo(false);
    }

    @Test
    public void PlayerAdvantageToWin() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");

        assertThat(match.getScore()).isEqualTo(List.of(Point.WIN, Point.FORTY));
        assertThat(match.hasEnded()).isEqualTo(true);
        assertThat(match.getWinner()).isEqualTo(p1);
    }

    @Test
    public void ignoreActionsOncePlayerHasWon() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Match match = new Match(p1, p2);

        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p1");
        ScoreProcessor.processOutcome(match, "p2");
        ScoreProcessor.processOutcome(match, "p1");
        assertThat(match.getScore()).isEqualTo(List.of(Point.WIN, Point.LOVE));
        assertThat(match.hasEnded()).isEqualTo(true);
        assertThat(match.getWinner()).isEqualTo(p1);
    }
}
