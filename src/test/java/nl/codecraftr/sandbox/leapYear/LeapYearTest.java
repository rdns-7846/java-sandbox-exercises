package nl.codecraftr.sandbox.leapYear;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LeapYearTest {

    @Test
    public void testLeapYearFour() {
        assertThat(LeapYear.isLeapYear(4)).isEqualTo(true);
    }

    @Test
    public void testLeapYear100() {
        assertThat(LeapYear.isLeapYear(100)).isEqualTo(false);
    }

    @Test
    public void testLeapYear400() {
        assertThat(LeapYear.isLeapYear(400)).isEqualTo(true);
    }
}
