package nl.codecraftr.sandbox.marsRover;

import lombok.Getter;

public class Coordinate {

    public final int MAX_FIELD = 5;

    private int x;
    private int y;

    @Getter
    private boolean accessible;

    public Coordinate(int x, int y) {
        this.x = this.wrapCoordinateIfNeeded(x);
        this.y = this.wrapCoordinateIfNeeded(y);
        this.accessible = true;
    }

    public String getPosition() {
        return String.format("(%d,%d)", this.x, this.y);
    }

    private int wrapCoordinateIfNeeded(int coordinateNumeral) {
        if (coordinateNumeral < 0) {
            return MAX_FIELD - 1;
        }
        if (coordinateNumeral >= MAX_FIELD) {
            return 0;
        }
        return coordinateNumeral;
    }

    public Coordinate move(Direction direction) {
        switch (direction) {
            case NORTH -> {
                return new Coordinate(this.x, this.y - 1);
            }
            case EAST -> {
                return new Coordinate(this.x + 1, this.y);
            }
            case SOUTH -> {
                return new Coordinate(this.x, this.y + 1);
            }
            default -> { // WEST
                return new Coordinate(this.x - 1, this.y);
            }
        }
    }
}
