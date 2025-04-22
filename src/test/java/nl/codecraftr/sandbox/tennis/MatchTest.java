package nl.codecraftr.sandbox.tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MatchTest {

    @Test
    public void TestMatchInitialisedAtLoveLove() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Match match = new Match(p1, p2);
        assertThat(match.getScore()).containsExactly(Point.LOVE, Point.LOVE);
    }

    @Test
    public void TestMatchNotEndedAtInitialisation() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Match match = new Match(p1, p2);
        assertThat(match.hasEnded()).isEqualTo(false);
    }

    @Test
    public void TestMatchEndedWhenPlayerTwoWins() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Match match = new Match(p1, p2);
        p2.setPoint(Point.WIN);
        assertThat(match.hasEnded()).isEqualTo(true);
    }

    @Test
    public void TestMatchEndedWhenPlayerOneWins() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Match match = new Match(p1, p2);
        p1.setPoint(Point.WIN);
        assertThat(match.hasEnded()).isEqualTo(true);
    }

    @Test
    public void TestGetPlayer1ReturnsPlayer1() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Match match = new Match(p1, p2);
        assertThat(match.getPlayer("p1")).isEqualTo(p1);
    }

    @Test
    public void TestGetOpponentPlayer1ReturnsPlayer2() {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Match match = new Match(p1, p2);
        assertThat(match.getOpponentOf("p1")).isEqualTo(p2);
    }
}
