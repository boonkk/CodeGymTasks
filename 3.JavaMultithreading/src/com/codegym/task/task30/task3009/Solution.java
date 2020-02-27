package com.codegym.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Palindrome?

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        // Expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        // Expected output: [6]
        System.out.println(getRadix("5321"));       // Expected output: []
        System.out.println(getRadix("1A"));         // Expected output: []

        System.out.println("picza " + isPalindrome("picza"));
        System.out.println("aaawaaa " + isPalindrome("aaawaaa"));
        System.out.println("koza " + isPalindrome("koza"));
        System.out.println("12421 " + isPalindrome("12421"));


    }

    private static Set<Integer> getRadix(String number) {
        String numberWithoutLetters = number.replaceAll("[^0-9.]", "");
        if(numberWithoutLetters.length()!=number.length())
            return new HashSet<Integer>();

        HashSet<Integer> resultSet = new HashSet<>();

        for(int i=2;i<=36;i++) {
            if(isPalindrome(Integer.toString(Integer.parseInt(number),i)))
                resultSet.add(i);
        }
        return resultSet;
    }

    public static boolean isPalindrome(String number) {
        char[] wordTable = number.toCharArray();
        int tableLength = wordTable.length;

            for(int i=0;i<tableLength/2;i++) {
                if(wordTable[i]==wordTable[tableLength-1-i]) {

                } else return false;
            }


        return true;
    }
}