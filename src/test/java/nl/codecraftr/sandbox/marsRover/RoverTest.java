package nl.codecraftr.sandbox.marsRover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoverTest {

    @Test
    public void testRoverActionLeft() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.NORTH);
        var action = Action.LEFT;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void testRoverActionRight() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.NORTH);
        var action = Action.RIGHT;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void testRoverActionLeftEast() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.EAST);
        var action = Action.LEFT;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void testRoverActionRightEast() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.EAST);
        var action = Action.RIGHT;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void testRoverActionLeftSouth() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.SOUTH);
        var action = Action.LEFT;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void testRoverActionRightSouth() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.SOUTH);
        var action = Action.RIGHT;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void testRoverActionLeftWest() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.WEST);
        var action = Action.LEFT;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void testRoverActionRightWest() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.WEST);
        var action = Action.RIGHT;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void testRoverActionForwardNorth() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.NORTH);
        var action = Action.FORWARD;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,4)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void testRoverActionForwardSouth() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.SOUTH);
        var action = Action.FORWARD;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(0,1)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void testRoverActionForwardWest() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.WEST);
        var action = Action.FORWARD;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(4,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void testRoverActionForwardEast() {
        var coordinate = new Coordinate(0, 0);
        var rover = new Rover(coordinate, Direction.EAST);
        var action = Action.FORWARD;

        var resultRover = rover.doAction(action);
        assertThat(resultRover.getCoordinate().getPosition()).isEqualTo("(1,0)");
        assertThat(resultRover.getDirection()).isEqualTo(Direction.EAST);
    }
}
