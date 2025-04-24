package nl.codecraftr.sandbox.marsRover;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import lombok.Getter;

public class Map {

    List<List<Coordinate>> grid;

    @Getter
    Rover rover;

    public Map(String[][] mapRepresentation) {
        this.grid = IntStream.range(0, mapRepresentation.length)
                .boxed()
                .map(row -> IntStream.range(0, mapRepresentation[row].length)
                        .mapToObj(col -> new Coordinate(row, col, fieldIsAccesible(mapRepresentation[row][col])))
                        .toList())
                .toList();
        this.rover = IntStream.range(0, mapRepresentation.length)
                .boxed()
                .flatMap(row -> IntStream.range(0, mapRepresentation[row].length)
                        .mapToObj(col -> fieldToRover(mapRepresentation[row][col], row, col)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElse(null);
    }

    private boolean fieldIsAccesible(String field) {
        switch (field) {
            case "🌳" -> {
                return false;
            }
            default -> {
                return true;
            }
        }
    }

    private Optional<Rover> fieldToRover(String field, int x, int y) {
        var coordinate = new Coordinate(x, y, true);
        switch (field) {
            case "E" -> {
                return Optional.of(new Rover(coordinate, Direction.EAST));
            }
            case "S" -> {
                return Optional.of(new Rover(coordinate, Direction.SOUTH));
            }
            case "W" -> {
                return Optional.of(new Rover(coordinate, Direction.WEST));
            }
            case "N" -> {
                return Optional.of(new Rover(coordinate, Direction.NORTH));
            }
        }
        return Optional.empty();
    }

    public Coordinate getCoordinateInMap(int x, int y) {
        return grid.get(x).get(y);
    }
}
