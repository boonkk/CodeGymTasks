package com.codegym.task.task38.task3803;

/* 
Runtime exceptions (unchecked exceptions)

*/

import java.util.ArrayList;
import java.util.Arrays;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        String[] strArray = new String[] { "John", "Snow" };
        ArrayList<String> strList = (ArrayList<String>) Arrays.asList(strArray);
        System.out.println("String list: " + strList);    }

    public void methodThrowsNullPointerException() {
        String[] s = null;
        s[3]="s";
    }

    public static void main(String[] args) {

    }
}