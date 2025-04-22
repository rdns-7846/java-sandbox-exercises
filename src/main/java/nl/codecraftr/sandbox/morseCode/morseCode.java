package nl.codecraftr.sandbox.morseCode;

import java.util.*;
import java.util.stream.Stream;

public class morseCode {
    static Map<String, String> morseMap = new HashMap<>();

    static {
        // Letters
        morseMap.put("A", ".-");
        morseMap.put("B", "-...");
        morseMap.put("C", "-.-.");
        morseMap.put("D", "-..");
        morseMap.put("E", ".");
        morseMap.put("F", "..-.");
        morseMap.put("G", "--.");
        morseMap.put("H", "....");
        morseMap.put("I", "..");
        morseMap.put("J", ".---");
        morseMap.put("K", "-.-");
        morseMap.put("L", ".-..");
        morseMap.put("M", "--");
        morseMap.put("N", "-.");
        morseMap.put("O", "---");
        morseMap.put("P", ".--.");
        morseMap.put("Q", "--.-");
        morseMap.put("R", ".-.");
        morseMap.put("S", "...");
        morseMap.put("T", "-");
        morseMap.put("U", "..-");
        morseMap.put("V", "...-");
        morseMap.put("W", ".--");
        morseMap.put("X", "-..-");
        morseMap.put("Y", "-.--");
        morseMap.put("Z", "--..");

        // Digits
        morseMap.put("0", "-----");
        morseMap.put("1", ".----");
        morseMap.put("2", "..---");
        morseMap.put("3", "...--");
        morseMap.put("4", "....-");
        morseMap.put("5", ".....");
        morseMap.put("6", "-....");
        morseMap.put("7", "--...");
        morseMap.put("8", "---..");
        morseMap.put("9", "----.");

        // Common Punctuation
        morseMap.put(".", ".-.-.-");
        morseMap.put(",", "--..--");
        morseMap.put("?", "..--..");
        morseMap.put("!", "-.-.--");
        morseMap.put("-", "-....-");
        morseMap.put("/", "-..-.");
        morseMap.put("'", ".----.");
        morseMap.put("()", "-.--.-");
        morseMap.put(":", "---...");
        morseMap.put(";", "-.-.-.");
        morseMap.put("=", "-...-");
    }

    private static String characterToMorse(String character) {
        if (character.equals(" ")) return "\\";
        String morseCode = morseMap.get(character);
        if (morseCode == null) {
            throw new MorseCodeNotFoundException("Morse code not found for: " + character);
        }
        return morseCode;
    }

    public static String textToMorse(String text) {
        var uppercase = text.toUpperCase(Locale.getDefault()).trim();
        List<String> morseText =
                Stream.of(uppercase.split("")).map(morseCode::characterToMorse).toList();
        return String.join(" ", morseText);
    }

    /// ///////////////////////////////////////////////////////////////////////////////////

    private static String morseToChar(String morseChar) {
        for (Map.Entry<String, String> entry : morseMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (morseChar.equals(value)) {
                return key;
            }
        }

        throw new MorseCodeNotFoundException("Morse code not found for: " + morseChar);
    }

    private static String morseWordToChars(String morseWord) {
        List<String> charactersInWord =
                Arrays.stream(morseWord.split(" ")).map(morseCode::morseToChar).toList();
        return String.join("", charactersInWord);
    }

    public static String morseToText(String morse) {
        List<String> words =
                Arrays.stream(morse.split("\\\\")).map(String::trim).toList();

        List<String> wordsInCharacters =
                words.stream().map(morseCode::morseWordToChars).toList();
        //        List<String> characters = words.stream()
        //                .flatMap(n -> morseCode.morseWordToChars(n).stream())
        //                .toList();

        return String.join(" ", wordsInCharacters);
    }
}
