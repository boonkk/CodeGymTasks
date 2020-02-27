package com.codegym.task.task19.task1924;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/* 
Replacing numbers

*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"zero");
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"six");
        map.put(7,"seven");
        map.put(8,"eight");
        map.put(9,"nine");
        map.put(10,"ten");
        map.put(11,"eleven");
        map.put(12,"twelve");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader freader = new BufferedReader(new FileReader(fileName));
        String[] arr=null;
        while(freader.ready()) {
            String s = freader.readLine();
            arr = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                String x1 = arr[i].replaceAll("[a-zA-Z0-9]", "");
                arr[i] = arr[i].replaceAll("[^a-zA-Z0-9]", "");
                try {
                    int x = Integer.parseInt(arr[i]);
                    if (x >= 0 && x <= 12)
                        arr[i] = map.get(x);
                } catch (Exception ignored) {
                }
                sb.append(arr[i] + x1 + " ");
            }
            System.out.println(sb.toString().trim());
        }


            freader.close();
        }

    }

