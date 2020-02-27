package com.codegym.task.task19.task1920;

/* 
The richest

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            HashMap<String, Double> map = new HashMap<>();

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


        map=map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        double maxSum=0d;
        for(Map.Entry<String,Double> k : map.entrySet()) {

            if(maxSum<=k.getValue())
            maxSum = k.getValue();
        }
        TreeMap<String,Double> result = new TreeMap<>();
        for(Map.Entry<String,Double> k : map.entrySet()) {

            if(maxSum==k.getValue()) {
                result.put(k.getKey(),k.getValue());
            }
        }
        for(Map.Entry<String,Double> k : result.entrySet()){
            System.out.println(k.getKey());
        }

    }
}
