package com.codegym.task.task14.task1420;

/* 
GCD

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a=0;
        int b=0;

            a = Integer.parseInt(reader.readLine());
            if (a <= 0 ) throw new NumberFormatException("Number needs to be positive");
            b = Integer.parseInt(reader.readLine());
            if (b <= 0 ) throw new NumberFormatException("Number needs to be positive");
            System.out.println(gcd(a,b));

    }
    public static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }

}
