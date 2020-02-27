package com.codegym.task.task39.task3908;

import java.util.*;

/*
Is a palindrome possible?

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("aaaaaaaaaaa"));
        System.out.println(isPalindromePermutation("123456654321"));
        System.out.println(isPalindromePermutation(""));
        System.out.println(isPalindromePermutation("a"));
        System.out.println(isPalindromePermutation("12"));
        System.out.println(isPalindromePermutation("aa"));
        System.out.println(isPalindromePermutation("121"));
        System.out.println(isPalindromePermutation("                        "));
        System.out.println(isPalindromePermutation(" "));
        System.out.println(isPalindromePermutation("1112221111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111112111111111111111111111111111111"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Set<Character> doneLetters = new HashSet<>();
        int oddOccurences = 0;
        int counter=0;
        char[] letters = s.toLowerCase().toCharArray();
        for(int i=0; i<letters.length; i++) {
            char checkedLetter = letters[i];
            if(doneLetters.contains(checkedLetter)) {
                continue;
            }
            for(int j=0; j<letters.length; j++) {
                if(checkedLetter == letters[j])
                    counter++;
            }
            if(counter%2==1)
                oddOccurences++;
            counter =0;
            doneLetters.add(checkedLetter);

        }

        if (oddOccurences>1)
            return false;
        return true;
    }
}
