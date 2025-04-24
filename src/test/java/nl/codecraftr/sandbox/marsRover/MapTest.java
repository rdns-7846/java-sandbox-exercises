package nl.codecraftr.sandbox.marsRover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MapTest {

    @Test
    void testLoadingFullMapRoverExistsAtRightCoordinate() {
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

    @Test
    void testLoadingFullMapTreesAreNotAccessible() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"🟩", "🌳", "🟩", "🟩", "🟩"},
            {"E", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        assertThat(map.getCoordinateInMap(3, 1).getPosition()).isEqualTo("(3,1)");
        assertThat(map.getCoordinateInMap(3, 1).isAccessible()).isEqualTo(false);
    }

    @Test
    void testLoadingFullMapGreensAreAccessible() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"🟩", "🌳", "🟩", "🟩", "🟩"},
            {"E", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        assertThat(map.getCoordinateInMap(0, 0).getPosition()).isEqualTo("(0,0)");
        assertThat(map.getCoordinateInMap(0, 0).isAccessible()).isEqualTo(true);
    }

    @Test
    void testLoadingFullMapCoordinateAtRoverIsAccessible() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"🟩", "🌳", "🟩", "🟩", "🟩"},
            {"E", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        assertThat(map.getCoordinateInMap(4, 0).isAccessible()).isEqualTo(true);
    }
}
