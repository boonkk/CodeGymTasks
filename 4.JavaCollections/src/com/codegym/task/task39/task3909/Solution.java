package com.codegym.task.task39.task3909;

/* 
One change

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("biba", "baba"));
        System.out.println(isOneEditAway("dong", "doong"));
        System.out.println(isOneEditAway("biiba", "biba"));
        System.out.println(isOneEditAway("bibucza", "baba"));
        System.out.println(isOneEditAway("b", ""));
        System.out.println(isOneEditAway("a", "b"));
        System.out.println(isOneEditAway("", ""));
        System.out.println(isOneEditAway("bca", "bab"));
        System.out.println(isOneEditAway("1111111", "11111111"));
        System.out.println(isOneEditAway(null, null));
        System.out.println(isOneEditAway("bibAA", "biba"));
    }

    public static boolean isOneEditAway(String first, String second) {
        int length1= first.length();
        int length2 = second.length();
        int lenDif = Math.abs(length1 - length2);

        if (lenDif > 1)
            return false;
        if (first.equals("") && second.equals(""))
            return true;
        if(first.equals(second))
            return true;

        StringBuffer sb1 = (first.length() >= second.length()) ? new StringBuffer(first) : new StringBuffer(second);
        StringBuffer sb2 = (first.length() < second.length()) ? new StringBuffer(first) : new StringBuffer(second);

        for (int i = 0; i < sb2.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) {
                if (lenDif != 0) {
                    sb1.deleteCharAt(i);
                } else {
                    sb1.deleteCharAt(i);
                    sb2.deleteCharAt(i);
                }
                break;
            }
        }

        if (sb1.length() != sb2.length())
            sb1.deleteCharAt(sb1.length()-1);

        return sb1.toString().equals(sb2.toString());

    }
}
