package ru.test;

import ru.test.exceptions.NotSupportedNumberException;
import ru.test.exceptions.NotSupportedOperationException;
import ru.test.exceptions.WrongNumCountException;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        SimpleCalculator calc = new Calculator();
        System.out.println("Calc run, type \"exit\" for exit");
        while (true) {
            Scanner in = new Scanner(System.in);
            String inputRow = in.nextLine();
            if (inputRow.equals("exit")) {
                System.out.println("Calc stopped");
                System.exit(0);
            }
            try {
                calc.calcAnswerFromString(inputRow);
                System.out.println(calc.showAnswer());
            } catch (NotSupportedOperationException | NotSupportedNumberException | WrongNumCountException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

}
