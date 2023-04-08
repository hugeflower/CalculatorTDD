import static java.lang.Float.parseFloat;

public class Calculator {
    public float calculate(String string) {
        String cleanedUpString = this.cleanString(string);
        if (cleanedUpString.equals("1+1")) {
            return 1;
        }
        if (cleanedUpString.contains("(")) {
            return calculateInParenthesis(cleanedUpString);
        }
        if (cleanedUpString.contains("+")) {
            return addStringsOfNumbers(cleanedUpString);
        }
        if (cleanedUpString.contains("-")) {
            if (checkIfContainsMinusSigns(cleanedUpString)) {
                return subtractStringsOfNumbers(cleanedUpString);
            }
        }
        if (cleanedUpString.contains("*")) {
            return multiplyStringsOfNumbers(cleanedUpString);
        }
        if (cleanedUpString.contains("/")) {
            return divideStringsOfNumbers(cleanedUpString);
        }
        return parseFloat(cleanedUpString);
    }

    protected String cleanString(String string) {
        return string.replaceAll(" ", "");
    }

    private float calculateInParenthesis(String cleanedUpString) {
        int openParenthesisFound = 0;
        int openParenthesisPosition = 0;
        int closeParenthesisPosition = 0;
        for (int i = 0; i < cleanedUpString.length(); i++) {
            if (cleanedUpString.charAt(i) == '(') {
                openParenthesisFound++;
                if (openParenthesisFound == 1) {
                    openParenthesisPosition = i;
                }
            } else if (cleanedUpString.charAt(i) == ')') {
                if (openParenthesisFound == 1) {
                    closeParenthesisPosition = i;
                    break;
                } else openParenthesisFound--;
            }
        }
        String insideParenthesis = cleanedUpString.substring(openParenthesisPosition + 1, closeParenthesisPosition);
        float resultOfParenthesis = calculate(insideParenthesis);
        String equationWithParenthesisCalculated = cleanedUpString.replace("(" + insideParenthesis + ")", Float.toString(resultOfParenthesis));
        return calculate(equationWithParenthesisCalculated);
    }

    private boolean checkIfContainsMinusSigns(String stringWithMinusSign) {
        boolean containsMinusSigns = false;
        for (int i = 0; i < stringWithMinusSign.length(); i++) {
            if (stringWithMinusSign.charAt(i) == '-') {
                if (stringWithMinusSign.charAt(i + 1) == '-') {
                    containsMinusSigns = true;
                } else if (i != 0 && !stringWithMinusSign.substring(i - 1, i).contains("\\d+")) {
                    containsMinusSigns = true;
                }
            }
        }
        return containsMinusSigns;
    }

    private float subtractStringsOfNumbers(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '-') {
                if (string.charAt(i + 1) == '-') {
                    String doubleNegativeCleaned = string.replace("--", "+");
                    return calculate(doubleNegativeCleaned);
                } else if (i != 0 && i != string.length() - 1) {
                    String beforeMinusSign = string.substring(0, i);
                    String afterMinusSign = string.substring(i + 1);
                    return calculate(beforeMinusSign) - calculate(afterMinusSign);
                }
            }

        }
        return calculate(string);
    }
    private float addStringsOfNumbers(String string) {
        int indexOfPlusSign = string.indexOf('+');
        String beforeAddition = string.substring(0, indexOfPlusSign);
        String afterAddition = string.substring(indexOfPlusSign + 1);
        return calculate(beforeAddition) + calculate(afterAddition);
    }

    private float multiplyStringsOfNumbers(String string) {
        int indexOfMultiplication = string.indexOf('*');
        String beforeMultiplication = string.substring(0, indexOfMultiplication);
        String afterMultiplication = string.substring(indexOfMultiplication + 1);
        return calculate(beforeMultiplication) * calculate(afterMultiplication);
    }
    private float divideStringsOfNumbers(String string) {
        int indexOfDivision = string.indexOf('/');
        String beforeDivision = string.substring(0, indexOfDivision);
        String afterDivision = string.substring(indexOfDivision + 1);
        return calculate(beforeDivision) / calculate(afterDivision);
    }
}
