package com.codegym.task.task37.task3714;

import java.io.IOException;

/* 
Ancient Rome

*/
public class Solution {


    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Input a roman numeral to be converted to decimal: ");
//        String romanString = bufferedReader.readLine();
//        System.out.println("Conversion result: " + romanToInteger(romanString));

        System.out.println(romanToInteger("IV") + " 4");
        System.out.println(romanToInteger("VIII") + " 8");
        System.out.println(romanToInteger("XV") + " 15");
        System.out.println(romanToInteger("XLIV") + " 44");

        System.out.println(romanToInteger("I") + " 1");
        System.out.println(romanToInteger("II") + " 2");
        System.out.println(romanToInteger("III") + " 3");
        System.out.println(romanToInteger("VII") + " 7");
        System.out.println(romanToInteger("XIII") + " 13");


    }

    public static int romanToInteger(String s) {
        int dec = 0;
        int last = 0;
        String romanUpper = s.toUpperCase();
        for (int i = romanUpper.length() - 1; i >= 0; i--) {
            char romanChar = romanUpper.charAt(i);

            switch (romanChar) {
                case 'M':
                    dec = decimalOption(1000, last, dec);
                    last = 1000;
                    break;

                case 'D':
                    dec = decimalOption(500, last, dec);
                    last = 500;
                    break;

                case 'C':
                    dec = decimalOption(100, last, dec);
                    last = 100;
                    break;

                case 'L':
                    dec = decimalOption(50, last, dec);
                    last = 50;
                    break;

                case 'X':
                    dec = decimalOption(10, last, dec);
                    last = 10;
                    break;

                case 'V':
                    dec = decimalOption(5, last, dec);
                    last = 5;
                    break;

                case 'I':
                    dec = decimalOption(1, last, dec);
                    last = 1;
                    break;
            }
        }
        return dec;
    }

    public static int decimalOption(int dec, int last, int lastDec) {
        if (last > dec) {
            return lastDec - dec;
        } else {
            return lastDec + dec;
        }
    }
}
