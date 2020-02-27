package com.codegym.task.task04.task0442;


/* 
Adding

*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        int sum=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int i=Integer.parseInt(reader.readLine());
            sum+=i;
            if(i==-1)
                break;
        }
        System.out.println(sum);
    }
}
