package com.codegym.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Minimum byte

*/


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileReader = new FileInputStream(fileName);
        int maxByte=fileReader.read();
        while (fileReader.available()>0) {
            int currentByte = fileReader.read();
            if (currentByte<maxByte) {
                maxByte=currentByte;
            }
        }
        System.out.println(maxByte);
        fileReader.close();
    }
}
