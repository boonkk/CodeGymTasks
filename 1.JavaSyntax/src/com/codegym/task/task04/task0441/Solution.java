package com.codegym.task.task04.task0441;


/* 
Somehow average

*/
import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[3];
        for(int i=0;i<3;i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(numbers);
        System.out.println(numbers[1]);
    }
}
