package com.codegym.task.task19.task1927;

/* 
Contextual advertising

*/

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();
    public static final String adText = "CodeGym - online Java courses";
    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String[] lines = outputStream.toString().split("\n");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<lines.length;i++) {
            sb.append(lines[i])
                    .append("\n");
            if(i%2==1) {
                sb.append(adText)
                        .append("\n");
            }
        }
        System.setOut(console);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
