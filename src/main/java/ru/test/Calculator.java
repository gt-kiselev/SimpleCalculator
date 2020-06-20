package ru.test;

import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.NotSupportedOperationException;
import ru.test.exceptions.WrongNumCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator implements SimpleCalculator {

    private int minNumber = 1;
    private int maxNumber = 10;
    private final List<String> operations = new ArrayList<>(Arrays.asList("+", "-", "/", "*"));

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
    public int calcOperation(int firstNum, int secondNum, String operation)
            throws NotSupportedOperationException, NotSupportedNumberException {
        checkOperation(operation);
        checkNumber(firstNum);
        checkNumber(secondNum);

        return calcAction(firstNum, secondNum, operation);
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

    public static void main(String[] args) {
        SimpleCalculator calc = new Calculator();
        System.out.println("Calc run");
        while (true) {
            Scanner in = new Scanner(System.in);
            InputParser inputParser;
            try {
                inputParser = new InputParser(in.nextLine());
                int answer = calc.calcOperation(
                        inputParser.getFirstNumber(), inputParser.getSecondNumber(), inputParser.getAction());
                System.out.println(answer);
            } catch (NotSupportedOperationException | NotSupportedNumberException | WrongNumCountException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
