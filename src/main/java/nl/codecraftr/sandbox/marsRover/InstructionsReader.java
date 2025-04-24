package nl.codecraftr.sandbox.marsRover;

import java.util.Arrays;
import java.util.List;

public class InstructionsReader {

    public static List<Action> toActionList(String instructions) {
        return Arrays.stream(instructions.split(""))
                .map(InstructionsReader::translateAction)
                .toList();
    }

    private static Action translateAction(String action) {
        switch (action) {
            case "L" -> {
                return Action.LEFT;
            }
            case "R" -> {
                return Action.RIGHT;
            }
            case "F" -> {
                return Action.FORWARD;
            }
            default -> throw new RuntimeException("Illegal Action");
        }
    }
}
