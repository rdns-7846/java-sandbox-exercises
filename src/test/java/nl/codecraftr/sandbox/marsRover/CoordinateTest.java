package nl.codecraftr.sandbox.marsRover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CoordinateTest {
    @Test
    public void testCoordinateNoWrap() {
        var coordinate = new Coordinate(0, 0, true);
        assertThat(coordinate.getPosition()).isEqualTo("(0,0)");
    }

    @Test
    public void testCoordinateWrapX() {
        var coordinate = new Coordinate(-1, 0, true);
        assertThat(coordinate.getPosition()).isEqualTo("(4,0)");
    }

    @Test
    public void testCoordinateWrapY() {
        var coordinate = new Coordinate(0, -1, true);
        assertThat(coordinate.getPosition()).isEqualTo("(0,4)");
    }

    @Test
    public void testCoordinateWrapXY() {
        var coordinate = new Coordinate(-1, -1, true);
        assertThat(coordinate.getPosition()).isEqualTo("(4,4)");
    }
}
