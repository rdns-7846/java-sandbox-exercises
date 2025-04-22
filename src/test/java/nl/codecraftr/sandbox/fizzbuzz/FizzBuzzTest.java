package nl.codecraftr.sandbox.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {
    @Test
    void a_number_is_returned() {
        assertThat(FizzBuzz.parse_divisor(1)).isEqualTo("1");
    }

    @Test
    void fizz_is_returned() {
        assertThat(FizzBuzz.parse_divisor(3)).isEqualTo("Fizz");
    }

    @Test
    void buzz_is_returned() {
        assertThat(FizzBuzz.parse_divisor(5)).isEqualTo("Buzz");
    }

    @Test
    void fizzbuzz_is_returned() {
        assertThat(FizzBuzz.parse_divisor(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void fizzbuzz_is_returned_for_multiples_of_15() {
        assertThat(FizzBuzz.parse_divisor(30)).isEqualTo("FizzBuzz");
    }

    @Test
    void fizz_is_returned_with_multiplications_of_3() {
        assertThat(FizzBuzz.parse_divisor(48)).isEqualTo("Fizz");
    }

    @Test
    void buzz_is_returned_with_multiplications_of_5() {
        assertThat(FizzBuzz.parse_divisor(10)).isEqualTo("Buzz");
    }

    @Test
    void nothing_is_returned_when_input_larger_than_100() {
        assertThat(FizzBuzz.parse_divisor(102)).isEqualTo("");
    }

    @Test
    void nothing_is_returned_when_input_smaller_than_0() {
        assertThat(FizzBuzz.parse_divisor(-1)).isEqualTo("");
    }

    @Test
    void test_1_to_100() {
        List<String> expectedOutput = List.of(
                "1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz",
                "16",
                "17",
                "Fizz",
                "19",
                "Buzz",
                "Fizz",
                "22",
                "23",
                "Fizz",
                "Buzz",
                "26",
                "Fizz",
                "28",
                "29",
                "FizzBuzz",
                "31",
                "32",
                "Fizz",
                "34",
                "Buzz",
                "Fizz",
                "37",
                "38",
                "Fizz",
                "Buzz",
                "41",
                "Fizz",
                "43",
                "44",
                "FizzBuzz",
                "46",
                "47",
                "Fizz",
                "49",
                "Buzz",
                "Fizz",
                "52",
                "53",
                "Fizz",
                "Buzz",
                "56",
                "Fizz",
                "58",
                "59",
                "FizzBuzz",
                "61",
                "62",
                "Fizz",
                "64",
                "Buzz",
                "Fizz",
                "67",
                "68",
                "Fizz",
                "Buzz",
                "71",
                "Fizz",
                "73",
                "74",
                "FizzBuzz",
                "76",
                "77",
                "Fizz",
                "79",
                "Buzz",
                "Fizz",
                "82",
                "83",
                "Fizz",
                "Buzz",
                "86",
                "Fizz",
                "88",
                "89",
                "FizzBuzz",
                "91",
                "92",
                "Fizz",
                "94",
                "Buzz",
                "Fizz",
                "97",
                "98",
                "Fizz",
                "Buzz");

        List<String> resultList =
                IntStream.range(1, 101).mapToObj(FizzBuzz::parse_divisor).toList();

        assertThat(resultList).isEqualTo(expectedOutput);
    }
}
