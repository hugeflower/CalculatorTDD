import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void given1Plus1_whenAdding_thenReturns1() {
        float answer = calculator.calculate("1+1");

        assertEquals(1, answer, 0);
    }

    @Test
    public void givenTwoNumber_whenAdding_thenAddsValues() {
        String stringWithNumbersAndPlusSign = "1 + 2";

        float answer = calculator.calculate(stringWithNumbersAndPlusSign);

        assertEquals(3, answer, 0);
    }

    @Test
    public void givenStringWithSpaces_whenRemovingSpaces_thenReturnsStringWithoutSpaces() {
        String stringWithSpaces = "this has a lot of spaces";
        String stringWithoutSpaces = "thishasalotofspaces";

        String stringCleanedUp = calculator.cleanString(stringWithSpaces);

        assertEquals(stringWithoutSpaces, stringCleanedUp);
    }

    @Test
    public void givenNegativeNumbers_whenSubtracting_thenReturnsGoodAnswer() {
        String stringWithNegativeNumber = "-1 - -1";

        float answer = calculator.calculate(stringWithNegativeNumber);

        assertEquals(0, answer, 0);
    }

    @Test
    public void givenTwoNumbers_whenMultiplying_thenMultipliesValues() {
        String stringWithNumbersAndMultiplicationSign = "5*2";

        float answer = calculator.calculate(stringWithNumbersAndMultiplicationSign);

        assertEquals(10, answer, 0);
    }

    @Test
    public void givenTwoNumbers_whenDividing_thenDividesValues() {
        String stringWithNumbersAndDivisionSign = "10/2";

        float answer = calculator.calculate(stringWithNumbersAndDivisionSign);

        assertEquals(5, answer, 0);
    }

    @Test
    public void givenEquationWithParenthesis_whenCalculating_thenPriorityOfParenthesisIsAccounted() {
        String stringOfEquationWithParenthesis = "((((2+5))))*3";

        float answer = calculator.calculate(stringOfEquationWithParenthesis);

        assertEquals(21, answer, 0);
    }

    @Test
    public void givenFloatNumbers_whenCalculating_thenFloatAreManaged() {
        String stringWithFloat = "2.8*3-1";

        float answer = calculator.calculate(stringWithFloat);

        assertEquals(7.4, answer, 0.0001);
    }

    @Test
    public void givenMultipleOperators_whenCalculating_operatorPrecedenceIsManaged() {
        String stringWithMultipleOperators = "2+2*5+5";

        float answer = calculator.calculate(stringWithMultipleOperators);

        assertEquals(17, answer, 0.0001);
    }
}