package nl.codecraftr.sandbox.marsRover;

import lombok.Getter;

public class Rover {

    @Getter
    private Coordinate coordinate;

    @Getter
    private Direction direction;

    public Rover(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Rover doAction(Action action) {
        switch (action) {
            case FORWARD -> {
                return this.move();
            }
            default -> {
                var direction = this.determineNewDirection(action);
                return new Rover(this.coordinate, direction);
            }
        }
    }

    private Rover move() {
        var newCoordinate = this.coordinate.determineNeighbor(this.direction);
        if (newCoordinate.isAccessible()) {
            return new Rover(newCoordinate, this.direction);
        }
        return this;
    }

    private Direction determineNewDirection(Action action) {
        switch (action) {
            case LEFT -> {
                switch (direction) {
                    case Direction.NORTH -> {
                        direction = Direction.WEST;
                    }
                    case EAST -> {
                        direction = Direction.NORTH;
                    }
                    case SOUTH -> {
                        direction = Direction.EAST;
                    }
                    case WEST -> {
                        direction = Direction.SOUTH;
                    }
                }
            }
            case RIGHT -> {
                switch (direction) {
                    case Direction.NORTH -> {
                        direction = Direction.EAST;
                    }
                    case EAST -> {
                        direction = Direction.SOUTH;
                    }
                    case SOUTH -> {
                        direction = Direction.WEST;
                    }
                    case WEST -> {
                        direction = Direction.NORTH;
                    }
                }
            }
            default -> {}
        }
        return direction;
    }
}
