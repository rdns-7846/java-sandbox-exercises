package nl.codecraftr.sandbox.marsRover;

import lombok.Getter;

public class Coordinate {

    public final int MAX_FIELD = 5;

    @Getter
    private int x;

    @Getter
    private int y;

    @Getter
    private boolean accessible;

    public Coordinate(int x, int y, boolean accessible) {
        this.x = this.wrapCoordinateIfNeeded(x);
        this.y = this.wrapCoordinateIfNeeded(y);
        this.accessible = accessible;
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
}
