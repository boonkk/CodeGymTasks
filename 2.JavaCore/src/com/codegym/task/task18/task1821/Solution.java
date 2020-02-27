package com.codegym.task.task18.task1821;

/* 
Symbol frequency

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        TreeMap <Character, Integer> values = new TreeMap<>();
        while (fis.available()>0) {
            int a = fis.read();
            if (values.containsKey((char) a))
                values.put((char) a,values.get((char) a)+1);
            else
                values.put((char) a, 1);

        }
        for(Map.Entry<Character,Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        fis.close();
    }
}
