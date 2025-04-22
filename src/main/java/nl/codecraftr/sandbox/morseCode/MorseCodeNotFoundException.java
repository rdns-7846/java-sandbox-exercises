package nl.codecraftr.sandbox.morseCode;

public class MorseCodeNotFoundException extends RuntimeException {
    public MorseCodeNotFoundException(String message) {
        super(message);
    }
}
