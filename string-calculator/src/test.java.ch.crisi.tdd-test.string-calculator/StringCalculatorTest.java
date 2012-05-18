import exceptions.NegativeNumbersException;
import org.junit.*;


import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

    StringCalculator calc;

    @Before
    public void setupTest() {
        calc = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroOnEmptyString() {
        int result = calc.add("");
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnSumOfOneParameter() {
        int result = calc.add("1");
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnSumOfTwoParameters() {
        int result = calc.add("1,2");
        assertEquals(3, result);
    }

    @Test
    public void shouldReturnSumOfThreeParameters() {
        int result = calc.add("1,2,3");
        assertEquals(6, result);
    }

    @Test
    public void shouldReturnSumOfMultipleParameters() {
        int result = calc.add("1,2,3,4,5,6");
        assertEquals(21, result);
    }

    @Test
    public void shouldSupportNewLinesAndOfCommas() {
        int result = calc.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    public void shouldSupportCustomDelimiters() {
        int result = calc.add("//;\n1;2;3");
        assertEquals(6, result);
    }

    @Test(expected = NegativeNumbersException.class)
    public void shouldThrowExceptionIfOneNegativeNumbersArePassed() {
        calc.add("-1");
    }

    @Test(expected = NegativeNumbersException.class)
    public void shouldThrowExceptionIfMultipleNegativeNumbersArePassed() {
        calc.add("-1,-1,1");
    }

    @Test
    public void shouldIgnoreNumbersBiggerThanThousand() {
        int result = calc.add("1,1001");
        assertEquals(1, result);

        result = calc.add("1,1000");
        assertEquals(1001, result);
    }

    @Test
    public void shouldSupportCustomDelimitersOfAnyLength() {
        int result = calc.add("//[---]\n1---2---3");
        assertEquals(6, result);
    }

    @Test
    public void shouldEscapeRegexMetaCharDelimiters() {
        int result = calc.add(("//.\n1.2.3"));
        assertEquals(6, result);

        result = calc.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    public void shouldSupportMultipleCustomDelimitersOfAnyLength() {
        int result = calc.add("//[..][--]\n1..2--3");
        assertEquals(6, result);
    }

    @Test
    public void shouldSupportMultipleSameCustomDelimitersOfAnyLength() {
        int result = calc.add("//[..][..]\n1..2..3");
        assertEquals(6, result);
    }

    @Test
    public void shouldBeAbleToSetSingleDelimiterByMethod() {
        StringCalculator sc = new StringCalculator();
        sc.setDelimiters(":");
        int result = sc.add("1:2:3");
        assertEquals(6, result);
    }

    @Test
    public void shouldBeAbleToSetMultipleDelimitersByMethod() {
        StringCalculator sc = new StringCalculator();
        sc.setDelimiters("[..][--]");
        int result = sc.add("1..2--3");
        assertEquals(6, result);
    }

}
