package com.codegym.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

/* 
Sorting bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileReader = new FileInputStream(fileName);
        ArrayList<Integer> bytes = new ArrayList<>();

        while (fileReader.available()>0) {
            int a = fileReader.read();
            if(bytes.contains(a)){
                continue;
            } else
            bytes.add(a);
        }
        fileReader.close();
        Collections.sort(bytes);

        for(int a:bytes) {

            System.out.print(a + " ");
        }
    }
}
