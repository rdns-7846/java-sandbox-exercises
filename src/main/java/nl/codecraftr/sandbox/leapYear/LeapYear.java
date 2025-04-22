package nl.codecraftr.sandbox.leapYear;

public class LeapYear {

    public static boolean isLeapYear(int num) {
        return ((num % 4 == 0) && (num % 100 != 0)) || (num % 400 == 0);
    }
}
