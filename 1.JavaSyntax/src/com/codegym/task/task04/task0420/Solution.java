package com.codegym.task.task04.task0420;

/* 
Sorting three numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[3];
        for (int i=0;i<3;i++) {
            numbers[i]=Integer.parseInt(reader.readLine());
        }
        reader.close();
        for(int i=0;i<2;i++) {
            if(numbers[i]<numbers[i+1]){
                int temp = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1]=temp;
            }
        }
        for(int i=0;i<2;i++) {
            if(numbers[i]<numbers[i+1]){
                int temp = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1]=temp;
            }
        }

        System.out.print(numbers[0] + " " +numbers[1] +" "+ numbers[2]);
    }
}
