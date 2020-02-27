package com.codegym.task.task04.task0429;

/* 
Positive and negative numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[3];
        numbers[0] = Integer.parseInt(reader.readLine());
        numbers[1] = Integer.parseInt(reader.readLine());
        numbers[2] = Integer.parseInt(reader.readLine());
        int numberOfPositives = 0;
        int numberOfNegatives = 0;
        for(int i:numbers) {
            if(i>0)
                numberOfPositives++;
            if(i<0)
                numberOfNegatives++;
        }
        System.out.println("Number of negative numbers: " + numberOfNegatives);
        System.out.println("Number of positive numbers: " + numberOfPositives);

    }
}
