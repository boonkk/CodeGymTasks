package com.codegym.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Unequal exchange

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {

        long a = number >> i & 1;
        System.out.println(number + " >> " + (i&1) + " = " + a);
        long b = number >> j & 1;
        System.out.println(number + " >> " + (j&1) + " = " + b);
        if (a != b) {

            number = number & ~((1 << i) | (1 << j)) | (a << j) | (b << i);
        }
        return number;
    }
}