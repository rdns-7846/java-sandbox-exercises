package nl.codecraftr.sandbox.fizzbuzz;

public class FizzBuzz {
    public static String parse_divisor(int number) {
        if (number > 100 || number < 0) return "";

        if (number % 15 == 0) return "FizzBuzz";
        if (number % 5 == 0) return "Buzz";
        if (number % 3 == 0) return "Fizz";

        return "" + number;
    }

    public static String parse_stage_2(int number) {
        String result = "";
        String numberStr = String.valueOf(number);
        if (numberStr.contains("3") || number % 3 == 0) result += "Fizz";
        if (number % 3 == 0) result += "Fizz";
        if (numberStr.contains("5")) result += "Buzz";
        if (number % 5 == 0) result += "Buzz";
        if (result.isEmpty()) return numberStr;
        return result;
    }

    public static String chatgpt(int number) {

        StringBuilder result = new StringBuilder();
        boolean isFizz = number % 3 == 0 || String.valueOf(number).contains("3");
        boolean isBuzz = number % 5 == 0 || String.valueOf(number).contains("5");

        if (isFizz) {
            result.append("Fizz");
        }
        if (isBuzz) {
            result.append("Buzz");
        }

        // If neither Fizz nor Buzz, append the number itself
        if (!isFizz && !isBuzz) {

            result.append(number);
        }

        return result.toString();
    }
}
