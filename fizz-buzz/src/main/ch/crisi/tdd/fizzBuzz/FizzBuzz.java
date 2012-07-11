package ch.crisi.tdd.percentEncoder;

public class FizzBuzz {
    
    public static String process(int number) {
        if (multipleOfThreeAndFive(number))
            return "fizzBuzz";
        else if (multipleOfFive(number))
            return "buzz";
        else if (multipleOfThree(number))
            return "fizz";
        return String.valueOf(number);
    }

    private static boolean multipleOfThree(int number) {
        return number % 3 == 0;
    }

    private static boolean multipleOfFive(int number) {
        return number % 5 == 0;
    }

    private static boolean multipleOfThreeAndFive(int number) {
        return number % 5 == 0 && number % 3 == 0;
    }
}