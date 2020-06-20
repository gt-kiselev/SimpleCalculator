package ru.test;

import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.WrongNumCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    private int firstNumber;
    private int secondNumber;
    private String action;
    private final static List<String> romeChars = new ArrayList<>(Arrays.asList("I", "X", "V"));

    public InputParser(String inputString) throws WrongNumCountException, NotSupportedNumberException {
        parseRow(inputString);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public String getAction() {
        return action;
    }

    private void parseRow(String row) throws WrongNumCountException, NotSupportedNumberException {
        String[] rowElements = row.trim().split(" ");
        if (rowElements.length != 3) {
            throw new WrongNumCountException();
        }

        if (!compareEqualNumFormat(rowElements[0], rowElements[2])) {
            throw new NotSupportedNumberException();
        }
        this.firstNumber = parseNumber(rowElements[0]);
        this.secondNumber = parseNumber(rowElements[2]);
        this.action = rowElements[1];
    }

    /**
     * Compare num format of two numbers
     * @param firstNumber
     * @param secondNumber
     * @return  true - if both numbers have the same format
     */
    static boolean compareEqualNumFormat(String firstNumber, String secondNumber) {

        for (String s1: romeChars) {
            if (firstNumber.contains(s1)) {
                for (String s2: romeChars) {
                    if (secondNumber.contains(s2)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /**
     * Get arab number from string
     * @param strNumber
     * @return
     */
    private int parseNumber(String strNumber) throws NotSupportedNumberException {

        for (String romeChar: romeChars) {
            if (strNumber.contains(romeChar)) {
                return RomanNumber.toInt(strNumber);
            }
        }
        return Integer.parseInt(strNumber);
    }

}
