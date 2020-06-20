package ru.test;

import org.junit.Assert;
import org.junit.Test;
import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.WrongNumCountException;

public class InputParserTest {



    @Test
    public void parseNumber() throws WrongNumCountException, NotSupportedNumberException {

        InputParser inputParser = new InputParser("5 + 6");
        Assert.assertEquals(5, inputParser.getFirstNumber());
        Assert.assertEquals(6, inputParser.getSecondNumber());

        InputParser inputParser2 = new InputParser("V + VI");
        Assert.assertEquals(5, inputParser2.getFirstNumber());
        Assert.assertEquals(6, inputParser2.getSecondNumber());

    }

    @Test
    public void compareEqualNumFormat() {
        Assert.assertTrue("must be true", InputParser.compareEqualNumFormat("I", "V"));
        Assert.assertFalse("must be false", InputParser.compareEqualNumFormat("I", "5"));
    }

    @Test
    public void parseRow() {

        Assert.assertThrows(WrongNumCountException.class, () -> {
            new InputParser("5-4");
        });

        Assert.assertThrows(WrongNumCountException.class, () -> {
            new InputParser("5 -4");
        });
        Assert.assertThrows(WrongNumCountException.class, () -> {
            new InputParser("5 - 4 + 6");
        });

        Assert.assertThrows(NotSupportedNumberException.class, () -> {
            new InputParser("I - 4");
        });
    }
}
