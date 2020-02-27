package com.codegym.task.task39.task3910;

/* 
isPowerOfThree

*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfThree(int n) {
        if(n==0)
            return false;
        int k=n;
        while(k%3==0) {
            k=k/3;
        }
        if(k==1)
            return true;
        return false;
    }
}
