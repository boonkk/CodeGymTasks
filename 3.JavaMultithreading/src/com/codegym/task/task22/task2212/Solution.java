package com.codegym.task.task22.task2212;

/* 
Phone number verification

*/
public class Solution {
    public static boolean checkPhoneNumber(String phoneNumber) {
        if(phoneNumber==null)
            return false;

        if(phoneNumber.equals("") || phoneNumber.equals(null)) {
            return false;
        }

        int digitsCount = 0;
        for(int i=0;i<phoneNumber.length();i++) {
            if(Character.isDigit(phoneNumber.charAt(i))) {
                digitsCount++;
            }
        }
        if(digitsCount!=10&&digitsCount!=12)
            return false;
        if(phoneNumber.charAt(0)=='+') {
            if(!(digitsCount==12)) {
                return false;
            }
            if(!Character.isDigit(phoneNumber.charAt(phoneNumber.length()-1)))
                return false;
        }
        if(digitsCount==10) {
            if(!(phoneNumber.charAt(0)=='(') && !(Character.isDigit(phoneNumber.charAt(0)))) {
                return false;
            }
            if(!Character.isDigit(phoneNumber.charAt(phoneNumber.length()-1)))
                return false;
        }

        if(phoneNumber.contains("(") && phoneNumber.contains(")")) {
            if(phoneNumber.lastIndexOf('(')!=phoneNumber.indexOf('('))
                return false;
            if(phoneNumber.lastIndexOf(')')!=phoneNumber.indexOf(')'))
                return false;
            if(phoneNumber.lastIndexOf(')')>phoneNumber.indexOf('-') && phoneNumber.contains("-"))
                return false;
            if(phoneNumber.indexOf(')')-phoneNumber.indexOf('(')!=4)
                return false;

        }
        int k=0;
        for(int i=0;i<phoneNumber.length();i++) {
            if(phoneNumber.charAt(i)=='-')
                k++;
            if(phoneNumber.charAt(i)=='-')
                if(phoneNumber.charAt(i-1)=='-')
                    return false;
        }
        if(k>2)
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPhoneNumber("+380501234567"));
        System.out.println(checkPhoneNumber("+38(050)1234567"));
        System.out.println(checkPhoneNumber("+38050123-45-67"));
        System.out.println(checkPhoneNumber("050123-456"));
        System.out.println("tru u gury");
        System.out.println(checkPhoneNumber("4068606606"));
        System.out.println(checkPhoneNumber("+38)050(1234567"));
        System.out.println(checkPhoneNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkPhoneNumber("050xxx4567"));
        System.out.println(checkPhoneNumber("050123456"));
        System.out.println(checkPhoneNumber("(0)501234567"));



    }
}
