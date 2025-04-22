package nl.codecraftr.sandbox.romanNumerals;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {

    private static final Map<Integer, String> romanMap = new LinkedHashMap<>();

    static {
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
    }

    public static String toRoman(int num) {
        if (num < 0 || num > 3999) {
            throw new RomanNumeralException("Invalid number: " + num);
        }
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            if (entry.getKey() == num) return entry.getValue();
            else if (entry.getKey() <= num) {
                return entry.getValue() + toRoman(num - entry.getKey());
            }
        }
        return "";
    }
}
