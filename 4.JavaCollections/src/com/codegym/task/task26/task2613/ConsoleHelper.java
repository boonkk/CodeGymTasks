package com.codegym.task.task26.task2613;

import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptedOperationException {
        String input = "";
        try {
            input = reader.readLine();
            if (input.equalsIgnoreCase("exit")) {
                throw new InterruptedOperationException();
            }
        } catch (IOException ignored) {}

        return input;
    }

    public static Operation requestOperation() throws InterruptedOperationException {
        do {
            writeMessage("Available operation:\n1) INFO\n2) DEPOSIT\n3) WITHDRAW\n4) EXIT");
            try {
                String input = readString();
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                writeMessage("Wrong input. Please try Again.");
                continue;
            }
        } while (true);
    }


    public static String requestCurrencyCode() throws InterruptedOperationException {
        String code = null;
        writeMessage("Please enter currency code:");
        while (true) {
            code = readString();
            if (code.length() == 3)
                break;
            else
                writeMessage("Error, try again:");

        }
        return code.toUpperCase();
    }

    public static String[] getTwoValidNumbers(String currencyCode) throws InterruptedOperationException {
        writeMessage("Input denomines and number of banknotes separated by space:");

        String[] input;
        while (true) {
            input = readString().split(" ");

            int nominal = 0;
            int total = 0;
            try {
                nominal = Integer.parseInt(input[0]);
                total = Integer.parseInt(input[1]);
            } catch (Exception e) {
                writeMessage("Try again.");
                continue;
            }
            if( nominal <= 0 || total <= 0 ) {
                writeMessage("Try again.");
                continue;
            }
            break;
        }
        return input;
    }
}
