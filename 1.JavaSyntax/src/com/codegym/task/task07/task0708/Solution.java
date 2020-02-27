package com.codegym.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Longest string

*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<String>();
        for(int i=0;i<5;i++) {
            strings.add(reader.readLine());
        }
        int maxLength = 0;
        ArrayList<String> maxString = new ArrayList<>();
        int i=0;
        for (String s : strings) {
            if (maxLength < s.length()){
                maxLength = s.length();
            }
        }
        for (String s:strings){
            if (maxLength == s.length()){
                maxString.add(s);
                i++;
            }
        }
        for (String s: maxString) {
            System.out.println(s);
        }


    }
}
