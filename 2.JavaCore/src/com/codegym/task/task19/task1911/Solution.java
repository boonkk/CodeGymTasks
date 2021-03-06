package com.codegym.task.task19.task1911;

/* 
Reader wrapper

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();

        System.setOut(console);
        System.out.println(result.toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This is text for testing");
        }
    }
}
