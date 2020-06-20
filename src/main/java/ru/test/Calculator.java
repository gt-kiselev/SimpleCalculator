package ru.test;

import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.NotSupportedOperationException;
import ru.test.exceptions.WrongNumCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator implements SimpleCalculator {

    private int minNumber = 1;
    private int maxNumber = 10;
    private final List<String> operations = new ArrayList<>(Arrays.asList("+", "-", "/", "*"));
    private NumFormat numFormat;
    private int answer;

    private void checkOperation(String operation) throws NotSupportedOperationException {
        if (!operations.contains(operation)) {
            throw new NotSupportedOperationException();
        }
    }

    private void checkNumber(int number) throws NotSupportedNumberException {
        if (number < minNumber || number > maxNumber) {
            throw new NotSupportedNumberException();
        }
    }

    @Override
    public int calcAnswerFromString(String rowAction)
            throws NotSupportedOperationException, NotSupportedNumberException, WrongNumCountException {

        InputParser inputParser = new InputParser(rowAction);

        checkOperation(inputParser.getAction());
        checkNumber(inputParser.getFirstNumber());
        checkNumber(inputParser.getSecondNumber());
        this.numFormat = inputParser.getFirstNumFormat();
        this.answer = calcAction(
                inputParser.getFirstNumber(), inputParser.getSecondNumber(), inputParser.getAction());
        return this.answer;
    }

    private int calcAction(int firstNumber, int secondNumber, String operation)
            throws NotSupportedOperationException {

        if (operation.equals("+")) {
            return sum(firstNumber, secondNumber);
        } else if (operation.equals("-")) {
            return subtract(firstNumber, secondNumber);
        } else if (operation.equals("/")) {
            return division(firstNumber, secondNumber);
        } else if (operation.equals("*")) {
            return multiplication(firstNumber, secondNumber);
        } else {
            throw new NotSupportedOperationException();
        }
    }

    /**
     * Get answer as string rome/arab
     * @return
     * @throws NotSupportedNumberException
     */
    public String showAnswer() throws NotSupportedNumberException {
        if (numFormat.equals(NumFormat.ARAB)) {
            return String.valueOf(this.answer);
        } else if (numFormat.equals(NumFormat.ROME)) {
            return RomanNumber.toRome(this.answer);
        } else {
            throw new NotSupportedNumberException();
        }
    }
}
