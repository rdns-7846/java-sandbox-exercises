package nl.codecraftr.sandbox.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FizzBuzzStage2Test {
    @Test
    void test_number_has_three_returns_Fizz() {
        assertThat(FizzBuzz.parse_stage_2(13)).isEqualTo("Fizz");
    }

    @Test
    void test_number_has_five_returns_Buzz() {
        assertThat(FizzBuzz.parse_stage_2(56)).isEqualTo("Buzz");
    }

    @Test
    void test_number_returns_FizzBuzz() {
        assertThat(FizzBuzz.parse_stage_2(53)).isEqualTo("FizzBuzz");
    }

    @Test
    void test_number_returns_FizzBuzzBuzz() {
        assertThat(FizzBuzz.parse_stage_2(35)).isEqualTo("FizzBuzzBuzz");
    }

    @Test
    void test_number_has_no_properties() {
        assertThat(FizzBuzz.parse_stage_2(2)).isEqualTo("2");
    }
}
