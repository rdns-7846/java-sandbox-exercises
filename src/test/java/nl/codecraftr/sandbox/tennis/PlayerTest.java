package nl.codecraftr.sandbox.tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void TestInitialisationPlayerPointIsLove() {
        var player = new Player("A");
        assertThat(player.getPoint()).isEqualTo(Point.LOVE);
    }

    @Test
    public void TestInitialisationPlayerHasWonIsFalse() {
        Player player = new Player("A");
        assertThat(player.hasWon()).isEqualTo(false);
    }

    @Test
    void TestSetPlayerPoint() {
        Player player = new Player("A");
        player.setPoint(Point.FIFTEEN);
        assertThat(player.getPoint()).isEqualTo(Point.FIFTEEN);
    }

    @Test
    void TestSetPlayerHasWon() {
        Player player = new Player("A");
        player.setPoint(Point.WIN);
        assertThat(player.hasWon()).isEqualTo(true);
    }

    @Test
    void TestPlayerHasName() {
        Player player = new Player("A");
        assertThat(player.getName()).isEqualTo("A");
    }
}
