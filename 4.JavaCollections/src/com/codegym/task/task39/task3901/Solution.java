package com.codegym.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Unique substrings

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if(s == null || s =="")
            return 0;
        Set<Character> occured = new HashSet<>();
        int longest = 0;
        int current = 0;
        for(int j=0; j<s.length(); j++){
            for(int i=j; i<s.length(); i++) {
                if(!occured.contains(s.charAt(i))) {
                    current++;
                    occured.add(s.charAt(i));
                } else {
                    if(current>longest)
                        longest=current;
                    current=0;
                    occured.clear();
                }
            }
        }
        if(longest==0)
            longest=current;
        return longest;
    }
}
