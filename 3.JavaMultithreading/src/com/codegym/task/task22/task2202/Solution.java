package com.codegym.task.task22.task2202;

/* 
Find a substring

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("CodeGym is the best place to learn Java."));
    }

    public static String getPartOfString(String string) throws StringTooShortException {
        if(string==null) {
            throw new StringTooShortException();
        }

        String[] words = string.split(" ");
        if(words.length<5)
            throw new StringTooShortException();
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<5;i++) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static class StringTooShortException extends RuntimeException {
    }
}