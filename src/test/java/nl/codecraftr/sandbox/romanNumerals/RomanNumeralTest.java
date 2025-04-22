package nl.codecraftr.sandbox.romanNumerals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RomanNumeralTest {

    @Test
    public void testRomanNumeralThousand() {
        assertThat(RomanNumeral.toRoman(1000)).isEqualTo("M");
    }

    @Test
    public void testRomanNumeralFiveHundred() {
        assertThat(RomanNumeral.toRoman(500)).isEqualTo("D");
    }

    @Test
    public void testRomanNumeralHundred() {
        assertThat(RomanNumeral.toRoman(100)).isEqualTo("C");
    }

    @Test
    public void testRomanNumeralFifty() {
        assertThat(RomanNumeral.toRoman(50)).isEqualTo("L");
    }

    @Test
    public void testRomanNumeralTen() {
        assertThat(RomanNumeral.toRoman(10)).isEqualTo("X");
    }

    @Test
    public void testRomanNumeralFive() {
        assertThat(RomanNumeral.toRoman(5)).isEqualTo("V");
    }

    @Test
    public void testRomanNumeralFour() {
        assertThat(RomanNumeral.toRoman(4)).isEqualTo("IV");
    }

    @Test
    public void testRomanNumeralOne() {
        assertThat(RomanNumeral.toRoman(1)).isEqualTo("I");
    }

    @Test
    public void testRomanNumeralTwo() {
        assertThat(RomanNumeral.toRoman(2)).isEqualTo("II");
    }

    @Test
    public void testRomanNumeralEight() {
        assertThat(RomanNumeral.toRoman(8)).isEqualTo("VIII");
    }

    @Test
    public void testRomanNumeral44() {
        assertThat(RomanNumeral.toRoman(44)).isEqualTo("XLIV");
    }

    @Test
    public void testRomanNumeral90() {
        assertThat(RomanNumeral.toRoman(90)).isEqualTo("XC");
    }

    @Test
    public void testRomanNumeral400() {
        assertThat(RomanNumeral.toRoman(400)).isEqualTo("CD");
    }

    @Test
    public void testRomanNumeral900() {
        assertThat(RomanNumeral.toRoman(900)).isEqualTo("CM");
    }

    @Test
    public void testRomanNumeralNine() {
        assertThat(RomanNumeral.toRoman(9)).isEqualTo("IX");
    }

    @Test
    public void testRomanNumeralInvalidNegativeNumber() {
        assertThatThrownBy(() -> {
                    RomanNumeral.toRoman(-2);
                })
                .isInstanceOf(RomanNumeralException.class)
                .hasMessage("Invalid number: " + -2);
    }

    @Test
    public void testRomanNumeralInvalidTooLargeNumber() {
        assertThatThrownBy(() -> {
                    RomanNumeral.toRoman(5000);
                })
                .isInstanceOf(RomanNumeralException.class)
                .hasMessage("Invalid number: " + 5000);
    }
}
