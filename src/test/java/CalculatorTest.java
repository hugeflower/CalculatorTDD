import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void given1Plus1_whenCalculating_thenReturns1() {
        int answer = calculator.calculate("1+1");

        assertEquals(answer, 1);
    }

    @Test
    public void givenTwoNumberAndPlusSign_whenCalculating_thenAddsValues() {
        String stringWithNumbersAndPlusSign = "1 + 2";

        int answer = calculator.calculate(stringWithNumbersAndPlusSign);

        assertEquals(answer, 3);
    }

    @Test
    public void givenStringWithSpaces_whenRemovingSpaces_thenReturnsStringWithoutSpaces() {
        String stringWithSpaces = "this has a lot of spaces";
        String stringWithoutSpaces = "thishasalotofspaces";

        String stringCleanedUp = calculator.removeSpaces(stringWithSpaces);

        assertEquals(stringWithoutSpaces, stringCleanedUp);
    }

    @Test
    public void givenNegativeNumbers_whenCalculating_thenReturnsGoodAnswer() {
        String stringWithNegativeNumber = "1 + -1";

        int answer = calculator.calculate(stringWithNegativeNumber);

        assertEquals(0, answer);
    }

    @Test
    public void givenTwoNumbersAndMultiplicationSign_whenCalculating_thenMultipliesValues() {
        String stringWithNumbersAndMultiplicationSign = "5*2";

        int answer = calculator.calculate(stringWithNumbersAndMultiplicationSign);

        assertEquals(10, answer);
    }

    @Test
    public void givenTwoNumbersAndDivisionSign_whenCalculating_thenDividesValues() {
        String stringWithNumbersAndDivisionSign = "10/2";

        int answer = calculator.calculate(stringWithNumbersAndDivisionSign);

        assertEquals(5, answer);
    }
}
