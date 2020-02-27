package com.codegym.task.task19.task1919;

/* 
Calculating salaries

*/


import java.io.*;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while (reader.ready()){
            String val = reader.readLine();
            String[] arr = val.split(" ");
            if(map.containsKey(arr[0])) {
                map.put(arr[0],map.get(arr[0])+Double.parseDouble(arr[1]));
            } else {
                map.put(arr[0],Double.parseDouble(arr[1]));
            }
        }
        reader.close();
        for(Map.Entry k : map.entrySet()) {
            System.out.println(k.getKey() + " " + k.getValue());
        }
    }
}
