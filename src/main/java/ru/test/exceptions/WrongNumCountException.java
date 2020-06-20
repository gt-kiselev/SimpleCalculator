package ru.test.exceptions;

public class WrongNumCountException extends Exception {

    public WrongNumCountException() {
        System.out.println("Wrong count of numbers or number format");
    }

}
