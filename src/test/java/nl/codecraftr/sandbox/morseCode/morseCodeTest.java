package nl.codecraftr.sandbox.morseCode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class morseCodeTest {
    @Test
    public void testMorseGetA() {
        assertThat(morseCode.textToMorse("A")).isEqualTo(".-");
    }

    @Test
    public void testMorseGet0() {
        assertThat(morseCode.textToMorse("0")).isEqualTo("-----");
    }

    @Test
    public void testMorseGetDot() {
        assertThat(morseCode.textToMorse(".")).isEqualTo(".-.-.-");
    }

    @Test
    public void testMorseGetALowercase() {
        assertThat(morseCode.textToMorse("a")).isEqualTo(".-");
    }

    @Test
    public void testMorseMultipleChars() {
        assertThat(morseCode.textToMorse("AB")).isEqualTo(".- -...");
    }

    @Test
    public void testMorseMultipleCharsWithSpace() {
        assertThat(morseCode.textToMorse("A B")).isEqualTo(".- \\ -...");
    }

    @Test
    public void testMorseMultipleCharsWithSpaceAtEnd() {
        assertThat(morseCode.textToMorse("AB ")).isEqualTo(".- -...");
    }

    @Test
    public void testMorseMultipleCharsWithSpaceAtBeginning() {
        assertThat(morseCode.textToMorse(" AB")).isEqualTo(".- -...");
    }

    @Test
    public void testMorseMultipleCharsWithUnknownCharacter() {
        assertThatThrownBy(() -> {
                    morseCode.textToMorse("@AB");
                })
                .isInstanceOf(MorseCodeNotFoundException.class)
                .hasMessage("Morse code not found for: @");
    }

    @Test
    public void testMorseToTextSingleChar() {
        assertThat(morseCode.morseToText(".-")).isEqualTo("A");
    }

    @Test
    public void testMorseToTextUnknownChar() {
        assertThatThrownBy(() -> {
                    morseCode.morseToText("!@#");
                })
                .isInstanceOf(MorseCodeNotFoundException.class)
                .hasMessage("Morse code not found for: !@#");
    }

    @Test
    public void testMorseToTextDoubleChar() {
        assertThat(morseCode.morseToText(".- .-")).isEqualTo("AA");
    }

    @Test
    public void testMorseToTextTripleChar() {
        assertThat(morseCode.morseToText(".- .- .-")).isEqualTo("AAA");
    }

    @Test
    public void testMorseToTextWithSpace() {
        assertThat(morseCode.morseToText(".- \\ .- .-")).isEqualTo("A AA");
    }

    @Test
    public void testMorseToTextWithOverlappingChars() {
        assertThat(morseCode.morseToText(".- .-.-.-")).isEqualTo("A.");
    }
}
