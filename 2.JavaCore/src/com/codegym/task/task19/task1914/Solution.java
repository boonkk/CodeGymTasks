package com.codegym.task.task19.task1914;

/* 
Problem solving

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

        String k = outputStream.toString();
        int a=0;
        int b=0;
        char c=0;
        int sum=0;
        if(k.indexOf("+")>0){
            a = Integer.parseInt(k.substring(0,k.indexOf("+")).trim());
            b = Integer.parseInt(k.substring(k.indexOf("+")+1,k.indexOf("=")).trim());
            c = '+';
            sum=a+b;
        } else if (k.indexOf("-")>0) {
            a = Integer.parseInt(k.substring(0,k.indexOf("-")).trim());
            b = Integer.parseInt(k.substring(k.indexOf("-")+1,k.indexOf("=")).trim());
            c = '-';
            sum=a-b;
        } else if (k.indexOf("*")>0) {
            a = Integer.parseInt(k.substring(0, k.indexOf("*")).trim());
            b = Integer.parseInt(k.substring(k.indexOf("*") + 1, k.indexOf("=")).trim());
            c = '*';
            sum = a*b;
        }
        System.setOut(console);
        System.out.println(a + " " + c + " " + b + " = " + sum);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

