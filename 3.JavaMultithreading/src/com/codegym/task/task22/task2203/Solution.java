package com.codegym.task.task22.task2203;

/* 
Between tabs

*/
public class Solution {
    public static String getPartOfString(String string) throws StringTooShortException {
        if(string==null)
            throw new StringTooShortException();
        if(!string.contains("\t"))
            throw new StringTooShortException();

        String[] words = string.split("\t");

        if(words.length<3)
        throw new StringTooShortException();

        return words[1];
    }

    public static class StringTooShortException extends Exception {
    }

    public static void main(String[] args) throws StringTooShortException {
        System.out.println(getPartOfString("\tCodeGym is the best place \tto learn Java\t."));
    }
}