package ru.test;

import ru.test.exceptions.NotSupportedNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumber {

    private static final List<String> romeNumbers = new ArrayList<>(Arrays.asList(
            "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
    ));

    public static int toInt(String value) throws NotSupportedNumberException {

        for (int i=0; i <= romeNumbers.size(); i++) {
            if (romeNumbers.get(i).equals(value)) {
                return i;
            }
        }
        throw new NotSupportedNumberException();
    }
}
