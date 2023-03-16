import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Calculator {
    public int calculate(String string) {
        String cleanedUpString = this.removeSpaces(string);
        if (cleanedUpString == "1+1") {
            return 1;
        }
        int total = 0;
        if (cleanedUpString.contains("+")) {
            return addStringsOfNumbers(cleanedUpString);
        }
        if (cleanedUpString.contains("*")) {
            return multiplyStringsofNumbers(cleanedUpString);
        }
        if (cleanedUpString.contains("/")) {
            return divideStringsOfNumbers(cleanedUpString);
        }
        return total;
    }

    protected String removeSpaces(String string) {
        return string.replaceAll(" ", "");
    }

    private int addStringsOfNumbers(String string) {
        int subtotal = 0;
        String[] sidesOfAnAddition = string.split("[+]");
        for (String numberString : sidesOfAnAddition) {
            subtotal += parseInt(numberString);
        }
        return subtotal;
    }

    private int multiplyStringsofNumbers(String string) {
        int subtotal = 1;
        String[] sidesOfAMultiplication = string.split("[*]");
        for (String numberString : sidesOfAMultiplication) {
            subtotal *= parseInt(numberString);
        }
        return subtotal;
    }
    private int divideStringsOfNumbers(String string) {
        int subtotal = 0;
        String[] sidesOfADivision = string.split("[/]");
        for (String numberString : sidesOfADivision) {
            if (subtotal == 0) {
                subtotal += parseInt(numberString);
            } else {
                subtotal /= parseInt(numberString);
            }
        }
        return subtotal;
    }
}
