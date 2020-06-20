package ru.test;

import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.NotSupportedOperationException;
import ru.test.exceptions.WrongNumCountException;

public interface SimpleCalculator {

    default int sum(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    default int subtract(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    default int multiplication(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    default int division(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    int calcAnswerFromString(String rowAction) throws NotSupportedOperationException, NotSupportedNumberException, WrongNumCountException;

    String showAnswer() throws NotSupportedNumberException;

}
