package com.codegym.task.task18.task1816;

/* 
ABCs

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;
        while (fis.available()>0) {
            int b = fis.read();
                if((b > 64 && b < 91) || (b > 96 && b < 123)){
                    count++;
                }

        }
        System.out.println(count);
        fis.close();
    }
}
