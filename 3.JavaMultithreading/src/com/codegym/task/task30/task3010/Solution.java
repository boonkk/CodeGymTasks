package com.codegym.task.task30.task3010;

/* 
Smallest possible radix

*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        boolean checkVar = false;
        for (int i = 2; i < 37; i++) {
            try {
                new BigDecimal(new BigInteger(args[0], i));
                System.out.println(i);
                checkVar = true;
                break;
            } catch (Exception ignored) {
            }
        }
        if( !checkVar ) System.out.println("Invalid");
    }
}