package nl.codecraftr.sandbox.marsRover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MapTest {

    @Test
    void testLoadingFullMapRoverExists() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"🟩", "🌳", "🟩", "🟩", "🟩"},
            {"E", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        assertThat(map.getRover().getDirection()).isEqualTo(Direction.EAST);
        assertThat(map.getRover().getCoordinate().getPosition()).isEqualTo("(4,0)");
    }
}
