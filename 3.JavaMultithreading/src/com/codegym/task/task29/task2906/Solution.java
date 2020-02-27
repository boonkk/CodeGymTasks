package com.codegym.task.task29.task2906;

/* 
Autoboxing features (part 2)

*/
public class Solution {
    public static void main(String[] args) {
        Integer a = getValue(Boolean.TRUE, Boolean.TRUE);   // 100 expected
        Integer b = getValue(Boolean.FALSE, Boolean.TRUE);  // 200 expected
        Integer c = getValue(Boolean.FALSE, Boolean.FALSE); // null expected

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static Integer getValue(boolean first, boolean second) {
        Integer result = first ? 100 : 0;
        if(result.equals(0))
        result = second ? 200 : null;

        return result;
    }
}