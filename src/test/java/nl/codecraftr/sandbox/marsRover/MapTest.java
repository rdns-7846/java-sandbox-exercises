package nl.codecraftr.sandbox.marsRover;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

    @Test
    void testMapAndActionMovesRover() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"🟩", "🌳", "🟩", "🟩", "🟩"},
            {"E", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        var actionList = List.of(Action.FORWARD);

        map.applyAction(actionList);
        assertThat(map.getRover().getDirection()).isEqualTo(Direction.EAST);
        assertThat(map.getRover().getCoordinate().getPosition()).isEqualTo("(4,1)");
    }

    @Test
    void testMapAndActionDoesNotMoveRoverWhenObstacle() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"E", "🌳", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        var actionList = List.of(Action.FORWARD);

        map.applyAction(actionList);
        assertThat(map.getRover().getDirection()).isEqualTo(Direction.EAST);
        assertThat(map.getRover().getCoordinate().getPosition()).isEqualTo("(3,0)");
    }

    @Test
    void testMapAndActionMovesDirectionOfRover() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"E", "🌳", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        var actionList = List.of(Action.LEFT);

        map.applyAction(actionList);
        assertThat(map.getRover().getDirection()).isEqualTo(Direction.NORTH);
        assertThat(map.getRover().getCoordinate().getPosition()).isEqualTo("(3,0)");
    }

    @Test
    void testMapAndActionMovesDirectionOfRoverRight() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"E", "🌳", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        var actionList = List.of(Action.RIGHT);

        map.applyAction(actionList);
        assertThat(map.getRover().getDirection()).isEqualTo(Direction.SOUTH);
        assertThat(map.getRover().getCoordinate().getPosition()).isEqualTo("(3,0)");
    }

    @Test
    void testMapAndActionMovesRoverAcrossMap() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"W", "🌳", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        var actionList = List.of(Action.FORWARD);

        map.applyAction(actionList);
        assertThat(map.getRover().getDirection()).isEqualTo(Direction.WEST);
        assertThat(map.getRover().getCoordinate().getPosition()).isEqualTo("(3,4)");
    }

    @Test
    void testMapAndApplyStringInstructions() {
        String[][] inputMatrix = {
            {"🟩", "🟩", "🌳", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🌳", "🟩"},
            {"W", "🌳", "🟩", "🟩", "🟩"},
            {"🟩", "🟩", "🟩", "🟩", "🟩"}
        };
        Map map = new Map(inputMatrix);
        var actionString = "FFFFFFFF";
        var actionList = InstructionsReader.toActionList(actionString);

        map.applyAction(actionList);
        assertThat(map.getRover().getDirection()).isEqualTo(Direction.WEST);
        assertThat(map.getRover().getCoordinate().getPosition()).isEqualTo("(3,2)");
    }
}
