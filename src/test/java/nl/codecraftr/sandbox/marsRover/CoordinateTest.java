package nl.codecraftr.sandbox.marsRover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CoordinateTest {
    @Test
    public void testCoordinateNoWrap() {
        var coordinate = new Coordinate(0, 0);
        assertThat(coordinate.getPosition()).isEqualTo("(0,0)");
    }

    @Test
    public void testCoordinateWrapX() {
        var coordinate = new Coordinate(-1, 0);
        assertThat(coordinate.getPosition()).isEqualTo("(4,0)");
    }

    @Test
    public void testCoordinateWrapY() {
        var coordinate = new Coordinate(0, -1);
        assertThat(coordinate.getPosition()).isEqualTo("(0,4)");
    }

    @Test
    public void testCoordinateWrapXY() {
        var coordinate = new Coordinate(-1, -1);
        assertThat(coordinate.getPosition()).isEqualTo("(4,4)");
    }

    @Test
    public void testCoordinateMoveNorth() {
        var coordinate = new Coordinate(0, 0);
        var newCoordinate = coordinate.move(Direction.NORTH);
        assertThat(newCoordinate).extracting(Coordinate::getPosition).isEqualTo("(0,4)");
    }

    @Test
    public void testCoordinateMoveSouth() {
        var coordinate = new Coordinate(0, 0);
        var newCoordinate = coordinate.move(Direction.SOUTH);
        assertThat(newCoordinate).extracting(Coordinate::getPosition).isEqualTo("(0,1)");
    }

    @Test
    public void testCoordinateMoveWest() {
        var coordinate = new Coordinate(0, 0);
        var newCoordinate = coordinate.move(Direction.WEST);
        assertThat(newCoordinate).extracting(Coordinate::getPosition).isEqualTo("(4,0)");
    }

    @Test
    public void testCoordinateMoveEast() {
        var coordinate = new Coordinate(0, 0);
        var newCoordinate = coordinate.move(Direction.EAST);
        assertThat(newCoordinate).extracting(Coordinate::getPosition).isEqualTo("(1,0)");
    }
}
