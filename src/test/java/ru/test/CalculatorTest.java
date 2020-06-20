package ru.test;

import org.junit.Test;
import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.NotSupportedOperationException;
import ru.test.exceptions.WrongNumCountException;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void checkNumbers() throws NotSupportedOperationException, NotSupportedNumberException, WrongNumCountException {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calcAnswerFromString("2 + 3"));
        assertEquals(5, calc.calcAnswerFromString("8 - 3"));
        assertEquals(6, calc.calcAnswerFromString("2 * 3"));
        assertEquals(3, calc.calcAnswerFromString("9 / 3"));
    }

}
