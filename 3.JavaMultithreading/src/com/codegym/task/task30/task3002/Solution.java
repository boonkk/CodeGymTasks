package com.codegym.task.task30.task3002;

/* 
Mastering the methods of the Integer class

*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); // 22
        System.out.println(convertToDecimalSystem("012"));  // 10
        System.out.println(convertToDecimalSystem("0b10")); // 2
        System.out.println(convertToDecimalSystem("62"));   // 62
    }
    ///sprawdzic dwa pierwsze znaki (czy ma 0, i co po zerze)
    public static String convertToDecimalSystem(String s) {
        if(s.startsWith("0")) {
            if(s.charAt(1)=='x') {
                return Integer.toString(Integer.parseInt(s.replaceAll("0x",""),16));
            } else if (s.charAt(1)=='b') {
                return Integer.toString(Integer.parseInt(s.replaceAll("0b",""),2));
            } else return Integer.toString(Integer.parseInt(s.replaceAll("0",""),8));
        }
        else return Integer.toString(Integer.parseInt(s,10));
    }
}
