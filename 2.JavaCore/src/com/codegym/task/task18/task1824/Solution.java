package com.codegym.task.task18.task1824;

/* 
Files and exceptions

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        FileInputStream file;
        try {
            while ((line = reader.readLine()) != null) {
                try {
                    file = new FileInputStream(line);
                    file.close();
                } catch (FileNotFoundException s) {
                    reader.close();
                    System.out.println(line);
                    return;

                }
            }
        }catch (IOException e) {

        }
    }
}
