package ru.test;

import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.WrongNumCountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    private int firstNumber;
    private NumFormat firstNumFormat;
    private int secondNumber;
    private NumFormat secondNumFormat;
    private String action;
    private final static List<String> romeChars = new ArrayList<>(Arrays.asList("I", "X", "V"));

    public InputParser(String inputString) throws WrongNumCountException, NotSupportedNumberException {
        parseRow(inputString);
    }

    public NumFormat getFirstNumFormat() {
        return firstNumFormat;
    }

    private void setFirstNumFormat(String strNumber) {
        this.firstNumFormat = getNumFormat(strNumber);
    }

    public NumFormat getSecondNumFormat() {
        return secondNumFormat;
    }

    private void setSecondNumFormat(String strNumber) {
        this.secondNumFormat = getNumFormat(strNumber);
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

        this.firstNumber = parseNumber(rowElements[0]);
        setFirstNumFormat(rowElements[0]);
        this.secondNumber = parseNumber(rowElements[2]);
        setSecondNumFormat(rowElements[2]);
        this.action = rowElements[1];

        if (!this.firstNumFormat.equals(this.secondNumFormat)) {
            throw new NotSupportedNumberException();
        }
    }

    public static NumFormat getNumFormat(String strNumber) {
        for (String s: romeChars) {
            if (strNumber.contains(s)) {
                return NumFormat.ROME;
            }
        }
        return NumFormat.ARAB;
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
