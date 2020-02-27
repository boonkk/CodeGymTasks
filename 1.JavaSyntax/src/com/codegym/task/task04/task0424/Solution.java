package com.codegym.task.task04.task0424;

/* 
Three numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //the simplest solution is here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        // first we check that if any two
        //numbers are equal, then we proceed
        if( a == b || b == c || a == c ) {
            if( a != b && a != c )
                System.out.print("1");
            else if( b != a && b != c )
                System.out.print("2");
            else if( c != a && c != b )
                System.out.print("3");
        }
    }
}
