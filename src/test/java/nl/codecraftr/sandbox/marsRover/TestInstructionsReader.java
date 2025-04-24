package nl.codecraftr.sandbox.marsRover;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TestInstructionsReader {

    @Test
    public void testReadingInstructionsStringToListOfActions() {
        String instructionString = "LRF";
        var instructionList = InstructionsReader.toActionList(instructionString);

        var result = List.of(Action.LEFT, Action.RIGHT, Action.FORWARD);
        assertThat(instructionList).isEqualTo(result);
    }

    @Test
    public void testReadingInstructionsIllegalAction() {
        String instructionString = "LRG";

        assertThatThrownBy(() -> {
                    InstructionsReader.toActionList(instructionString);
                })
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Illegal Action");
    }
}
