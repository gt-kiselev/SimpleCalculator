package ru.test;

import ru.test.exceptions.NotSupportedNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumber {

    private static final List<String> romeTen = new ArrayList<>(Arrays.asList(
            "N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
    ));

    private static final List<String> romeHundred = new ArrayList<>(Arrays.asList(
            "N", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"
    ));

    public static int toInt(String value) throws NotSupportedNumberException {

        for (int i = 0; i <= romeTen.size(); i++) {
            if (romeTen.get(i).equals(value)) {
                return i;
            }
        }
        throw new NotSupportedNumberException();
    }

    public static String toRome(int value) throws NotSupportedNumberException {
        try {
            if (value < 0) {
                return "-" + romeTen.get(Math.abs(value));
            } else if (value < 11) {
                return romeTen.get(value);
            } else if (value < 100) {
                String firstDigit = romeHundred.get(value / 10);
                String secondDigit = romeTen.get(value % 10);
                return firstDigit + secondDigit;
            } else if (value == 100) {
                return romeHundred.get(10);
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
