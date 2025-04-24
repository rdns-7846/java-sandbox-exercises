package nl.codecraftr.sandbox.marsRover;

import lombok.Getter;

public class Rover {

    @Getter
    private Coordinate coordinate;

    @Getter
    private Direction direction;

    @Getter
    private Coordinate prospectCoordinate;

    public Rover(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.prospectCoordinate = this.prospectCoordinate();
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
        if (prospectCoordinate.isAccessible()) {
            return new Rover(prospectCoordinate, this.direction);
        }
        return this;
    }

    public Coordinate prospectCoordinate() {
        var xPosition = this.coordinate.getX();
        var yPosition = this.coordinate.getY();

        switch (direction) {
            case NORTH -> {
                return new Coordinate(xPosition, yPosition - 1, true);
            }
            case EAST -> {
                return new Coordinate(xPosition + 1, yPosition, true);
            }
            case SOUTH -> {
                return new Coordinate(xPosition, yPosition + 1, true);
            }
            default -> { // WEST
                return new Coordinate(xPosition - 1, yPosition, true);
            }
        }
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
