import org.junit.Test;

import static ch.crisi.tdd.percentEncoder.FizzBuzz.process;
import static junit.framework.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void oneReturnsOne() {
        assertEquals("1", process(1));
    }

    @Test
    public void threeReturnsFizz() {
        assertEquals("fizz", process(3));
    }

    @Test
    public void fiveReturnsBuzz() {
        assertEquals("buzz", process(5));
    }

    @Test
    public void fifteenReturnsFizzBuzz() {
        assertEquals("fizzbuzz", process(15));
    }

    @Test
    public void multiplesOfOnlyThreeReturnFizz() {
        assertEquals("fizz", process(6));
        assertEquals("fizz", process(9));
        assertEquals("fizz", process(12));
    }

    @Test
    public void multiplesOfOnlyFiveReturnBuzz() {
        assertEquals("buzz", process(10));
        assertEquals("buzz", process(20));
        assertEquals("buzz", process(25));
    }

    @Test
    public void multiplesOfThreeAndFiveReturnFizzBuzz() {
        assertEquals("fizzbuzz", process(15));
        assertEquals("fizzbuzz", process(30));
        assertEquals("fizzbuzz", process(45));
    }

    @Test
    public void zeroReturnsFizzBuzz() {
        assertEquals("fizzbuzz", process(0));
    }

    @Test
    public void negativeNumbersCanBeProcessed() {
        assertEquals("fizz", process(-3));
    }

}