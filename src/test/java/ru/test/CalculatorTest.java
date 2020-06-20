package ru.test;

import org.junit.Before;
import org.junit.Test;
import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.NotSupportedOperationException;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Before
    public void BeforeTest() {
        Calculator calc = new Calculator();
    }

    @Test
    public void checkNumbers() throws NotSupportedOperationException, NotSupportedNumberException {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calcOperation(2, 3, "+"));
        assertEquals(5, calc.calcOperation(8, 3, "-"));
        assertEquals(6, calc.calcOperation(2, 3, "*"));
        assertEquals(3, calc.calcOperation(9, 3, "/"));
    }

}
