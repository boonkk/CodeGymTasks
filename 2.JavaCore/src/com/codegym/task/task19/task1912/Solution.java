package com.codegym.task.task19.task1912;

/* 
Reader Wrapper 2

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
        System.setOut(console);
        System.out.println(outputStream.toString().replace("te","??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("This is text for testing");
        }
    }
}
