package com.codegym.task.task04.task0427;

/* 
Describing numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        if(number.equals("") || number.length()>3||Integer.parseInt(number)<1)
            return;
        int lastDigit = Integer.parseInt(number.substring(number.length()-1));
        StringBuilder sb = new StringBuilder();
        if(lastDigit%2==0)
            sb.append("even ");
        else
            sb.append("odd ");

        if(number.length()==1)
            sb.append("single-digit number");
        if(number.length()==2)
            sb.append("two-digit number");
        if(number.length()==3)
            sb.append("three-digit number");
        System.out.println(sb.toString());

    }
}
