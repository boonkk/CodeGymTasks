package com.codegym.task.task18.task1807;

/* 
Counting commas

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e){
            fileName="";
        }
        try {
            FileInputStream fileReader = new FileInputStream(fileName);
            int count =0;
            while(fileReader.available()>0){
                if ((char)fileReader.read()==44) {
                    count++;
                }
            }
            System.out.println(count);
            fileReader.close();
        } catch (Exception e) {

        }

    }
}
