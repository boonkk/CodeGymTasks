package com.codegym.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Static modifiers: part 1

*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();
    static {
        labels.put(1d,"a");
        labels.put(5d,"b");
        labels.put(4d,"cd");
        labels.put(3d,"ef");
        labels.put(2d,"ghis");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
