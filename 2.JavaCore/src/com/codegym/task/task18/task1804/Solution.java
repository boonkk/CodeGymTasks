package com.codegym.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Rarest bytes

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileReader = new FileInputStream(fileName);
        HashMap<Integer, Integer> bytesOccurencies = new HashMap<>();
        while (fileReader.available()>0) {
            int currentByte = fileReader.read();
            if(bytesOccurencies.containsKey(currentByte)){
                bytesOccurencies.replace(currentByte,bytesOccurencies.get(currentByte)+1);
            } else {
                bytesOccurencies.put(currentByte,1);
            }
        }
        int maxOcc = 559595;
        int key = 45995;
        int occ;
        for(Map.Entry<Integer, Integer> entry : bytesOccurencies.entrySet()) {
            occ = entry.getValue();
            if (occ<maxOcc) {
                maxOcc = occ;
            }
        }
        for(Map.Entry<Integer, Integer> entry : bytesOccurencies.entrySet()) {
            if (entry.getValue()==maxOcc) {
                System.out.print(entry.getKey() + " ");
            }
        }
        //System.out.println(key);
        fileReader.close();
    }
}
