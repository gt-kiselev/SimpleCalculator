package ru.test;

import ru.test.exceptions.NotSupportedNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumber {

    private static final List<String> romeNumbers = new ArrayList<>(Arrays.asList(
            "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
    ));

    private static final List<String> romeDigits = new ArrayList<>(Arrays.asList(
            "0", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"
    ));

    public static int toInt(String value) throws NotSupportedNumberException {

        for (int i=0; i <= romeNumbers.size(); i++) {
            if (romeNumbers.get(i).equals(value)) {
                return i;
            }
        }
        throw new NotSupportedNumberException();
    }

    public static String toRome(int value) throws NotSupportedNumberException {
        try {
            if (value < 11) {
                return romeNumbers.get(value);
            } else if (value < 100) {
                String firstDigit = romeDigits.get(value / 10);
                String secondDigit = romeNumbers.get(value % 10);
                return firstDigit + secondDigit;
            } else if (value == 100) {
                return romeDigits.get(10);
            } else {
                throw new NotSupportedNumberException();
            }

        } catch (IndexOutOfBoundsException e) {
            throw new NotSupportedNumberException();
        }
    }

    public static void main(String[] args) {
        int val = 79;
        System.out.println(val / 10);
        System.out.println(val % 10);
    }

}
